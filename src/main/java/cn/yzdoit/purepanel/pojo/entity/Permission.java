package cn.yzdoit.purepanel.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

/**
 * 权限定义表
 *
 * @author 闫政
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "权限定义表")
@TableName(value = "pp_permission")
@EqualsAndHashCode(callSuper = true)
public class Permission extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -5624938720200922829L;

    /**
     * 父级id
     */
    @TableField(value = "pid")
    @Schema(description = "父级id")
    private String pid;

    /**
     * 名称
     */
    @TableField(value = "name")
    @Schema(description = "名称")
    private String name;

    /**
     * 菜单级别 正数菜单 负数按钮
     */
    @TableField(value = "level")
    @Schema(description = "菜单级别 正数菜单 负数按钮")
    private Integer level;

    /**
     * 前端访问路径
     */
    @TableField(value = "path")
    @Schema(description = "前端访问路径")
    private String path;

    /**
     * 前端组件路径，相对pages文件夹。或者 iframe 的地址
     */
    @TableField(value = "component_path")
    @Schema(description = "前端组件路径，相对pages文件夹。或者 iframe 的地址")
    private String componentPath;

    /**
     * 重定向的路径
     */
    @TableField(value = "redirect")
    @Schema(description = "重定向的路径")
    private String redirect;

    /**
     * 菜单标题中文名
     */
    @TableField(value = "title_cn")
    @Schema(description = "菜单标题中文名")
    private String titleCn;

    /**
     * 菜单标题英文名
     */
    @TableField(value = "title_en")
    @Schema(description = "菜单标题英文名")
    private String titleEn;

    /**
     * 图标
     */
    @TableField(value = "icon")
    @Schema(description = "图标")
    private String icon;

    /**
     * 菜单展示顺序 数字越小越靠前
     */
    @TableField(value = "order_no")
    @Schema(description = "菜单展示顺序 数字越小越靠前")
    private Integer orderNo;

    /**
     * 是否从菜单栏隐藏 0否1是
     */
    @TableField(value = "is_hidden")
    @Schema(description = "是否从菜单栏隐藏 0否1是")
    private Integer isHidden;

    /**
     * 是否 iframe 0否1是
     */
    @TableField(value = "is_iframe")
    @Schema(description = "是否 iframe 0否1是")
    private Integer isIframe;

    /**
     * 是否从新标签页打开 iframe 0否1是（外链）
     */
    @TableField(value = "is_new_tab_iframe")
    @Schema(description = "是否从新标签页打开 iframe 0否1是（外链）")
    private Integer isNewTabIframe;

    /**
     * 缓存路由 0否1是
     */
    @TableField(value = "keep_alive")
    @Schema(description = "缓存路由 0否1是")
    private Integer keepAlive;

    /**
     * 默认展开 0否1是
     */
    @TableField(value = "expanded")
    @Schema(description = "默认展开 0否1是")
    private Integer expanded;
}
