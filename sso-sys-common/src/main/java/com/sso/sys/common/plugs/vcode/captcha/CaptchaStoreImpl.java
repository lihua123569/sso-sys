package com.sso.sys.common.plugs.vcode.captcha;

import com.sso.sys.common.utils.EhcacheHelper;

public class CaptchaStoreImpl implements ICaptchaStore{

	

		@Override
		public String get(String chcacheName,String ticket) {
			Object obj = EhcacheHelper.get(chcacheName, ticket);
			if (obj != null) {
				return String.valueOf(obj);
			}
			return null;
		}

		@Override
		public boolean put(String chcacheName,String ticket, String captcha) {
			EhcacheHelper.put(chcacheName, ticket, captcha);
			return true;
		}

}
