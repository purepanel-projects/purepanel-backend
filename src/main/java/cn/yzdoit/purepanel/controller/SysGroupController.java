package cn.yzdoit.purepanel.controller;

import cn.yzdoit.purepanel.pojo.entity.SysGroup;
import cn.yzdoit.purepanel.pojo.res.Res;
import cn.yzdoit.purepanel.service.SysGroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 群组信息相关接口
 *
 * @author 闫政
 * @since 2025/7/7 05:26 星期一
 */
@RestController
@RequestMapping("/sysGroup")
@RequiredArgsConstructor
@Tag(name = "群组信息相关接口")
public class SysGroupController {

    private final SysGroupService sysGroupService;

    @GetMapping("/allTreeList")
    @Operation(summary = "获取树形列表")
    public Res<List<?>> allTreeList(@RequestParam(required = false) String name) {
        return Res.success(sysGroupService.allTreeList(name));
    }

    @PostMapping("/save")
    @Operation(summary = "保存群组信息")
    public Res<?> save(@RequestBody SysGroup req) {
        sysGroupService.saveOrUpdate(req);
        return Res.success();
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "删除指定群组")
    public Res<?> delete(@PathVariable String id) {
        sysGroupService.removeById(id);
        return Res.success();
    }
}
