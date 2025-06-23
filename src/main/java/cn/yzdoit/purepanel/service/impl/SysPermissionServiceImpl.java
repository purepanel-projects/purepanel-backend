package cn.yzdoit.purepanel.service.impl;

import cn.yzdoit.purepanel.mapper.SysPermissionMapper;
import cn.yzdoit.purepanel.pojo.entity.SysPermission;
import cn.yzdoit.purepanel.service.SysPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 权限定义相关服务
 *
 * @author 闫政
 * @since 2025/6/17 15:06 星期二
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {
}
