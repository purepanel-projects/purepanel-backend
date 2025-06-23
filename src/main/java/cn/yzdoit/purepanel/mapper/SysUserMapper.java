package cn.yzdoit.purepanel.mapper;

import cn.yzdoit.purepanel.pojo.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息表
 *
 * @author 闫政
 * @since 2025/6/23 06:42 星期一
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
}
