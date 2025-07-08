package cn.yzdoit.purepanel.controller;

import cn.yzdoit.purepanel.pojo.entity.SysRole;
import cn.yzdoit.purepanel.pojo.res.Res;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色信心相关接口
 *
 * @author 闫政
 * @since 2025/7/8 07:03 星期二
 */
@RestController
@RequestMapping("/sysRole")
public class SysRoleMapper {


    @GetMapping("/pageList")
    public Res<IPage<SysRole>> pageList(){
        return null;
    }
}
