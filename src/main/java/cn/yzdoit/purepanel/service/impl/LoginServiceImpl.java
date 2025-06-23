package cn.yzdoit.purepanel.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.yzdoit.purepanel.pojo.req.AccountLoginReq;
import cn.yzdoit.purepanel.pojo.res.AccountLoginRes;
import cn.yzdoit.purepanel.pojo.res.GetCaptchaRes;
import cn.yzdoit.purepanel.service.LoginService;
import com.wf.captcha.SpecCaptcha;
import org.springframework.stereotype.Service;

/**
 * 登录相关服务
 *
 * @author 闫政
 * @since 2025/6/23 06:58 星期一
 */
@Service
public class LoginServiceImpl implements LoginService {


    /**
     * 获取验证码
     *
     * @return GetCaptchaRes
     */
    @Override
    public GetCaptchaRes getCaptcha() {
        SpecCaptcha specCaptcha = new SpecCaptcha(140, 48, 4);
        String captchaKey = IdUtil.fastSimpleUUID();
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
        return null;
    }
}
