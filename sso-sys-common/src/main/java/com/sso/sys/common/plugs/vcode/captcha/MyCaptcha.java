package com.sso.sys.common.plugs.vcode.captcha;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * 验证码服务演示实例
 * 
 * @author hubin
 *
 */
public class MyCaptcha {

	public static final String CAPTCHA_TOKEN = "ctoken";
	private static final String CAPTCHA_CACHE = "captchaCache";
	
	/*
	 * 是否忽略验证内容大小写，默认 true
	 */
	private boolean ignoreCase = true;
	
	/*
	 * 图片验证码票据存储接口
	 */
	@Autowired
	private ICaptchaStore captchaStore;
	
	
	public void generate(String captcha, String ticket) {
		if (captcha != null) {
			String obj = captchaStore.get(CAPTCHA_CACHE,ticket);
			if (obj == null){
				captchaStore.put(CAPTCHA_CACHE,ticket, captcha);
			}
		}
	}

	public boolean verification(String ticket, String captcha) {
		if(StringUtils.isNoneBlank(ticket)){
			String tc = captchaStore.get(CAPTCHA_CACHE,ticket);
			if (tc != null) {
				if (ignoreCase) {
					return tc.equalsIgnoreCase(captcha);
				} else {
					return tc.equals(captcha);
				}
			}
			return false;
		}else{
			return true;
		}
	}

}
