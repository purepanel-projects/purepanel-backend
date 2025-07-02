package cn.yzdoit.purepanel.service;

import cn.yzdoit.purepanel.pojo.entity.SysUser;
import cn.yzdoit.purepanel.pojo.req.ChangePwdReq;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 用户信息相关服务
 *
 * @author 闫政
 * @since 2025/6/23 06:43 星期一
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 修改密码
     *
     * @param req 修改密码请求
     */
    void changePwd(ChangePwdReq req);
}
