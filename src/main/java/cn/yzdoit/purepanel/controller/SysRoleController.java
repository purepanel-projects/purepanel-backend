package cn.yzdoit.purepanel.controller;

import cn.hutool.core.util.StrUtil;
import cn.yzdoit.purepanel.pojo.entity.SysRole;
import cn.yzdoit.purepanel.pojo.req.RolePageListReq;
import cn.yzdoit.purepanel.pojo.res.Res;
import cn.yzdoit.purepanel.service.SysRoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 角色信息相关接口
 *
 * @author 闫政
 * @since 2025/7/8 07:03 星期二
 */
@RestController
@RequestMapping("/sysRole")
@Tag(name = "角色信息相关接口")
@RequiredArgsConstructor
public class SysRoleController {

    private final SysRoleService sysRoleService;


    @PostMapping("/pageList")
    @Operation(summary = "分页查询角色信息")
    public Res<IPage<SysRole>> pageList(@RequestBody RolePageListReq req) {
        IPage<SysRole> page = sysRoleService.page(new Page<>(req.getCurrent(), req.getSize()), Wrappers.<SysRole>lambdaQuery()
                .like(StrUtil.isNotBlank(req.getName()), SysRole::getName, req.getName())
                .orderByDesc(SysRole::getCreateTime));
        return Res.success(page);
    }

    @PostMapping("/save")
    @Operation(summary = "保存角色信息")
    public Res<?> save(@RequestBody SysRole req){
        sysRoleService.saveOrUpdate(req);
        return Res.success();
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除指定角色")
    public Res<?> delete(@PathVariable String id) {
        sysRoleService.removeById(id);
        return Res.success();
    }
}
