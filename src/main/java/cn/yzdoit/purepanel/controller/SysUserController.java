package cn.yzdoit.purepanel.controller;

import cn.yzdoit.purepanel.pojo.entity.SysUser;
import cn.yzdoit.purepanel.pojo.req.ChangePwdReq;
import cn.yzdoit.purepanel.pojo.res.Res;
import cn.yzdoit.purepanel.service.SysUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/pageList")
    public Res<IPage<SysUser>> pageList() {

        return null;
    }

    @PostMapping("/changeSelfPwd")
    @Operation(summary = "登录用户自行修改密码")
    public Res<?> changeSelfPwd(@RequestAttribute String loginUserId, @RequestBody ChangePwdReq req) {
        req.setUserId(loginUserId);
        req.setIsSelfChange(true);
        sysUserService.changePwd(req);
        return Res.success();
    }

    @PostMapping("/changePwd")
    @Operation(summary = "修改指定用户密码")
    public Res<?> changePwd(@RequestBody ChangePwdReq req) {
        req.setIsSelfChange(false);
        sysUserService.changePwd(req);
        return Res.success();
    }
}
