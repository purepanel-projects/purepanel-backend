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
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单权限相关接口
 *
 * @author 闫政
 * @since 2025/6/17 15:07 星期二
 */
@Slf4j
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

    @GetMapping("/getLoginUserPermission")
    @Operation(summary = "获取登录用户的权限")
    public Res<GetUserPermissionRes> getLoginUserPermission(@RequestAttribute("loginUserId") String loginUserId) {
        return Res.success(sysPermissionService.getUserPermission(loginUserId));
    }

    @PostMapping("/addOrUpdate")
    @Operation(summary = "保存菜单权限定义")
    public Res<?> addOrUpdate(@RequestBody SysPermission sysPermission) {
        sysPermissionService.addOrUpdate(sysPermission);
        return Res.success();
    }
}
