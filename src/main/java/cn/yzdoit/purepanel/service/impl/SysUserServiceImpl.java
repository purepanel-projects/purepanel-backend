package cn.yzdoit.purepanel.service.impl;

import cn.yzdoit.purepanel.mapper.SysUserMapper;
import cn.yzdoit.purepanel.pojo.entity.SysUser;
import cn.yzdoit.purepanel.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户信息相关服务
 *
 * @author 闫政
 * @since 2025/6/23 06:43 星期一
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
}
