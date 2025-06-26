package cn.yzdoit.purepanel.pojo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Purepanel 配置
 *
 * @author 闫政
 * @since 2025/6/17 16:50 星期二
 */
@Data
@ConfigurationProperties(prefix = "purepanel")
public class PurepanelProperties {

    /**
     * 是否开启接口异常信息返回
     */
    private Boolean resExceptionEnabled = Boolean.TRUE;

    /**
     * 登录配置
     */
    private LoginConfig loginConfig;

    @Data
    public static class LoginConfig {

        /**
         * 单会话登录 一个账号多次登录会互相挤下线
         */
        private Boolean singleSessionLoginEnabled = Boolean.TRUE;


        /**
         * 登录过期时间 单位小时
         */
        private Integer loginStatusExpireTime = 12;
    }
}
