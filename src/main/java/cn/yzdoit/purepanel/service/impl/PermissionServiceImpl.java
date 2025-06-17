package cn.yzdoit.purepanel.service.impl;

import cn.yzdoit.purepanel.mapper.PermissionMapper;
import cn.yzdoit.purepanel.pojo.entity.Permission;
import cn.yzdoit.purepanel.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author 闫政
 * @since 2025/6/17 15:06 星期二
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
}
