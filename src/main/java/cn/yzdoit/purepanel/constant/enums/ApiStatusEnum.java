package cn.yzdoit.purepanel.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiStatusEnum {

    /**
     * 成功
     */
    SUCCESS(200, "处理成功"),

    /**
     * 未授权（登录信息有误，需要重新登录）
     */
    UNAUTHORIZED(401, "未授权（登录信息有误 需要重新登录）"),

    /**
     * 无操作权限
     */
    NO_PERMISSIONS(403, "无操作权限"),

    /**
     * 失败
     */
    FAIL(500, "处理失败");

    /**
     * 状态码
     */
    private final Integer status;

    /**
     * 提示消息
     */
    private final String msg;
}