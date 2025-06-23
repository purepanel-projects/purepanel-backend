package cn.yzdoit.purepanel.controller;

import cn.yzdoit.purepanel.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息相关接口
 *
 * @author 闫政
 * @since 2025/6/23 06:44 星期一
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/sysUser")
public class SysUserController {

    private final SysUserService sysUserService;


}
