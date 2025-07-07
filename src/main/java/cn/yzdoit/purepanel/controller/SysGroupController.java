package cn.yzdoit.purepanel.controller;

import cn.yzdoit.purepanel.pojo.res.Res;
import cn.yzdoit.purepanel.service.SysGroupService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
public class SysGroupController {

    private final SysGroupService sysGroupService;

    @GetMapping("/allTreeList")
    @Operation(summary = "获取树形列表")
    public Res<List<?>> allTreeList(@RequestParam(required = false) String name) {
        return Res.success(sysGroupService.allTreeList(name));
    }
}
