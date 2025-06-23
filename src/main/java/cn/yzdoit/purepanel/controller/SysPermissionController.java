package cn.yzdoit.purepanel.controller;

import cn.yzdoit.purepanel.pojo.entity.SysPermission;
import cn.yzdoit.purepanel.pojo.res.GetUserPermissionRes;
import cn.yzdoit.purepanel.pojo.res.Res;
import cn.yzdoit.purepanel.pojo.res.SysPermissionTreeListRes;
import cn.yzdoit.purepanel.service.SysPermissionService;
import cn.yzdoit.purepanel.utils.TreeListUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜单权限相关接口
 *
 * @author 闫政
 * @since 2025/6/17 15:07 星期二
 */
@Tag(name = "菜单权限相关接口")
@RestController
@RequestMapping("/sysPermission")
@RequiredArgsConstructor
public class SysPermissionController {

    private final SysPermissionService sysPermissionService;

    @GetMapping("/treeList")
    @Operation(summary = "获取树形列表")
    public Res<List<SysPermissionTreeListRes>> allTreeList() {
        List<SysPermission> list = sysPermissionService.list();
        List<SysPermissionTreeListRes> tree = TreeListUtils.toTree(list, SysPermission::getId, SysPermission::getPid
                , SysPermissionTreeListRes::setChildren, SysPermissionTreeListRes.class);
        return Res.success(tree);
    }

    @GetMapping("/getUserPermission")
    @Operation(summary = "获取用户权限")
    public Res<GetUserPermissionRes> getUserPermission(@RequestParam("userId") String userId) {
        return null;
    }
}
