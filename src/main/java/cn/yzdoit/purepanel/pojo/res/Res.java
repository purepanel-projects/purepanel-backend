package cn.yzdoit.purepanel.pojo.res;

import cn.yzdoit.purepanel.constant.enums.ApiStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 接口基础响应类
 *
 * @author 闫政
 * @since 2025/6/17 15:49 星期二
 */
@Data
@AllArgsConstructor
@Schema(description = "接口基础响应类")
public class Res<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 5442158511583488874L;

    /**
     * 状态码
     */
    @Schema(description = "状态码")
    private Integer status;

    /**
     * 返回信息
     */
    @Schema(description = "返回信息")
    private String msg;

    /**
     * 返回数据
     */
    @Schema(description = "返回数据")
    private T payload;

    /**
     * 异常信息
     */
    @Schema(description = "异常信息")
    private String exceptionInfo;

    public static <T> Res<T> success() {
        return success(null);
    }

    public static <T> Res<T> success(T payload) {
        return build(ApiStatusEnum.SUCCESS.getStatus(), ApiStatusEnum.SUCCESS.getMsg(), payload, null);
    }

    public static <T> Res<T> build(Integer status, String msg, T payload, String exceptionInfo) {
        return new Res<>(status, msg, payload, exceptionInfo);
    }
}
