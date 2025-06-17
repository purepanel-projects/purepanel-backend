package cn.yzdoit.purepanel.pojo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 闫政
 * @since 2025/6/17 16:50 星期二
 */
@Data
@ConfigurationProperties(prefix = "purepanel")
public class PurepanelProperties {

    /**
     * 是否开启接口异常信息返回
     */
    private boolean resExceptionEnabled = true;
}
