package cn.yzdoit.purepanel.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.yzdoit.purepanel.mapper.SysPermissionMapper;
import cn.yzdoit.purepanel.mapper.SysRolePermissionMapper;
import cn.yzdoit.purepanel.mapper.SysUserRoleMapper;
import cn.yzdoit.purepanel.pojo.entity.SysPermission;
import cn.yzdoit.purepanel.pojo.entity.SysRolePermission;
import cn.yzdoit.purepanel.pojo.entity.SysUserRole;
import cn.yzdoit.purepanel.pojo.res.GetUserPermissionRes;
import cn.yzdoit.purepanel.pojo.res.SysPermissionTreeListRes;
import cn.yzdoit.purepanel.service.SysPermissionService;
import cn.yzdoit.purepanel.utils.TreeListUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 权限定义相关服务
 *
 * @author 闫政
 * @since 2025/6/17 15:06 星期二
 */
@Service
@RequiredArgsConstructor
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {

    private final SysUserRoleMapper sysUserRoleMapper;
    private final SysRolePermissionMapper sysRolePermissionMapper;
    private final SysPermissionMapper sysPermissionMapper;

    /**
     * 获取用户权限
     *
     * @param userId 用户id
     * @return GetUserPermissionRes
     */
    @Override
    public GetUserPermissionRes getUserPermission(String userId) {
        //获取用户角色
        List<String> roleIdList = sysUserRoleMapper.selectList(Wrappers.<SysUserRole>lambdaQuery()
                        .select(SysUserRole::getRoleId)
                        .eq(SysUserRole::getUserId, userId))
                .stream().map(SysUserRole::getRoleId).toList();
        if (CollectionUtil.isEmpty(roleIdList)) {
            return GetUserPermissionRes.empty();
        }
        //获取角色权限
        List<String> permissionIdList = sysRolePermissionMapper.selectList(Wrappers.<SysRolePermission>lambdaQuery()
                        .select(SysRolePermission::getPermissionId)
                        .in(SysRolePermission::getRoleId, roleIdList))
                .stream().map(SysRolePermission::getPermissionId).toList();
        if (CollectionUtil.isEmpty(permissionIdList)) {
            return GetUserPermissionRes.empty();
        }
        //获取权限信息
        List<SysPermission> permissionList = sysPermissionMapper.selectList(Wrappers.<SysPermission>lambdaQuery()
                .in(SysPermission::getId, permissionIdList));
        if (CollectionUtil.isEmpty(permissionList)) {
            return GetUserPermissionRes.empty();
        }
        //处理菜单信息
        List<SysPermission> menuList = permissionList.stream()
                .filter(p -> Objects.equals(p.getType(), 0)).toList();
        List<SysPermissionTreeListRes> menuTree = TreeListUtils.toTree(menuList, SysPermission::getId, SysPermission::getPid
                , SysPermissionTreeListRes::setChildren, SysPermissionTreeListRes.class);
        //处理按钮信息
        List<SysPermission> btnList = permissionList.stream()
                .filter(p -> Objects.equals(p.getType(), 1)).toList();
        //响应
        return GetUserPermissionRes.builder()
                .menuTree(menuTree)
                .btnList(btnList)
                .build();
    }
}
