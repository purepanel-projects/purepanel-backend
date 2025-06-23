package cn.yzdoit.purepanel.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.yzdoit.purepanel.constant.RedisPrefix;
import cn.yzdoit.purepanel.mapper.SysUserMapper;
import cn.yzdoit.purepanel.pojo.entity.SysUser;
import cn.yzdoit.purepanel.pojo.req.AccountLoginReq;
import cn.yzdoit.purepanel.pojo.res.AccountLoginRes;
import cn.yzdoit.purepanel.pojo.res.GetCaptchaRes;
import cn.yzdoit.purepanel.service.LoginService;
import cn.yzdoit.purepanel.utils.CheckUtils;
import cn.yzdoit.purepanel.utils.PwdUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.wf.captcha.SpecCaptcha;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 登录相关服务
 *
 * @author 闫政
 * @since 2025/6/23 06:58 星期一
 */
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final StringRedisTemplate redisTemplate;
    private final SysUserMapper sysUserMapper;

    /**
     * 获取验证码
     *
     * @return GetCaptchaRes
     */
    @Override
    public GetCaptchaRes getCaptcha() {
        SpecCaptcha specCaptcha = new SpecCaptcha(140, 48, 4);
        String captchaKey = IdUtil.fastSimpleUUID();
        redisTemplate.opsForValue().set(RedisPrefix.SYS_CAPTCHA + captchaKey, specCaptcha.text(), 5, TimeUnit.MINUTES);
        return GetCaptchaRes.builder()
                .captchaBase64(specCaptcha.toBase64())
                .captchaKey(captchaKey)
                .build();
    }

    /**
     * 账号登录
     *
     * @param req 请求参数
     * @return AccountLoginRes
     */
    @Override
    public AccountLoginRes accountLogin(AccountLoginReq req) {
        //前置校验
        String captchaCache = redisTemplate.opsForValue().get(RedisPrefix.SYS_CAPTCHA + req.getCaptchaKey());
        CheckUtils.notBlank(captchaCache, "验证码已过期，请重新获取");
        CheckUtils.equalsIgnoreCase(captchaCache, req.getCaptcha(), "验证码错误");
        SysUser sysUser = sysUserMapper.selectOne(Wrappers.<SysUser>lambdaQuery()
                .eq(SysUser::getAccount, req.getAccount()));
        CheckUtils.notNull(sysUser, "账号或密码错误");
        CheckUtils.check(sysUser.getStatus() == 0, "该账号已被禁用");
        CheckUtils.check(PwdUtils.check(req.getPwd(), sysUser.getSalt(), sysUser.getPwd()), "账号或密码错误");
        return null;
    }
}
