package cn.yzdoit.purepanel.controller;

import cn.yzdoit.purepanel.pojo.entity.Permission;
import cn.yzdoit.purepanel.pojo.res.PermissionTreeListRes;
import cn.yzdoit.purepanel.pojo.res.Res;
import cn.yzdoit.purepanel.service.PermissionService;
import cn.yzdoit.purepanel.utils.TreeListUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 闫政
 * @since 2025/6/17 15:07 星期二
 */
@Tag(name = "菜单权限相关接口")
@RestController
@RequestMapping("/permission")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @GetMapping("/treeList")
    @Operation(summary = "获取树形列表")
    public Res<List<PermissionTreeListRes>> treeList() {
        List<Permission> list = permissionService.list();
        List<PermissionTreeListRes> tree = TreeListUtils.toTree(list, Permission::getId, Permission::getPid
                , PermissionTreeListRes::setChildren, PermissionTreeListRes.class);
        return Res.success(tree);
    }
}
