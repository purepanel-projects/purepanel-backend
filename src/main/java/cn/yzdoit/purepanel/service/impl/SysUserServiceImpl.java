package cn.yzdoit.purepanel.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.yzdoit.purepanel.mapper.SysUserMapper;
import cn.yzdoit.purepanel.pojo.bo.TwoParams;
import cn.yzdoit.purepanel.pojo.entity.SysUser;
import cn.yzdoit.purepanel.pojo.req.ChangePwdReq;
import cn.yzdoit.purepanel.pojo.req.UserPageListReq;
import cn.yzdoit.purepanel.pojo.res.UserPageListRes;
import cn.yzdoit.purepanel.service.SysUserService;
import cn.yzdoit.purepanel.util.CheckUtil;
import cn.yzdoit.purepanel.util.PwdUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 用户信息相关服务
 *
 * @author 闫政
 * @since 2025/6/23 06:43 星期一
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private final SysUserMapper sysUserMapper;

    /**
     * 修改密码
     *
     * @param req 修改密码请求
     */
    @Override
    public void changePwd(ChangePwdReq req) {
        SysUser sysUser = sysUserMapper.selectById(req.getUserId());
        CheckUtil.notNull(sysUser, "用户不存在");
        if (req.getIsSelfChange()) {
            //检查旧密码
            CheckUtil.check(PwdUtil.verify(req.getOldPwd(), sysUser.getSalt(), sysUser.getPwd()), "旧密码错误");
        }
        //设置新密码
        TwoParams<String, String> pwdParams = PwdUtil.encode(req.getNewPwd());
        sysUser.setPwd(pwdParams.getA());
        sysUser.setSalt(pwdParams.getB());
        sysUserMapper.updateById(sysUser);
    }

    /**
     * 新增或修改用户信息
     *
     * @param sysUser 用户信息
     */
    @Override
    public void addOrUpdate(SysUser sysUser) {
        if (StrUtil.isBlank(sysUser.getId())) {
            //新增
            TwoParams<String, String> pwdParams = PwdUtil.encode(sysUser.getPwd());
            sysUser.setPwd(pwdParams.getA());
            sysUser.setSalt(pwdParams.getB());
            sysUserMapper.insert(sysUser);
        } else {
            //修改
            sysUserMapper.updateById(sysUser);
        }
    }

    /**
     * 分页查询用户信息
     *
     * @param req 分页查询用户信息请求参数
     * @return 用户信息分页
     */
    @Override
    public IPage<UserPageListRes> pageList(UserPageListReq req) {
        IPage<UserPageListRes> page = new Page<>(req.getCurrent(), req.getSize());
        return sysUserMapper.pageList(page, req);
    }
}
