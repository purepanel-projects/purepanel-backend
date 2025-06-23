package cn.yzdoit.purepanel.pojo.res;

import cn.yzdoit.purepanel.pojo.entity.SysUser;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 账号登录接口响应参数
 *
 * @author 闫政
 * @since 2025/6/23 08:57 星期一
 */
@Data
@Builder
@Schema(description = "账号登录接口响应参数")
public class AccountLoginRes implements Serializable {

    @Serial
    private static final long serialVersionUID = -2234109613974289380L;


    /**
     * token
     */
    @Schema(description = "token")
    private String token;

    /**
     * 用户信息
     */
    @Schema(description = "用户信息")
    private SysUser sysUser;
}
