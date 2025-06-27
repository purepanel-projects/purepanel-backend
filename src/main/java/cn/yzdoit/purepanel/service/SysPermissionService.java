package cn.yzdoit.purepanel.service;

import cn.yzdoit.purepanel.pojo.entity.SysPermission;
import cn.yzdoit.purepanel.pojo.res.GetUserPermissionRes;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 权限定义相关服务
 *
 * @author 闫政
 * @since 2025/6/17 15:06 星期二
 */
public interface SysPermissionService extends IService<SysPermission> {

    /**
     * 获取用户权限
     *
     * @param userId 用户id
     * @return GetUserPermissionRes
     */
    GetUserPermissionRes getUserPermission(String userId);


    /**
     * 保存菜单权限定义
     *
     * @param sysPermission 菜单权限信息
     */
    void addOrUpdate(SysPermission sysPermission);
}
