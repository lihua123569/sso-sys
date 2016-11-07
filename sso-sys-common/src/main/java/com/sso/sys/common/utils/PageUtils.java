package com.sso.sys.common.utils;

import com.baomidou.mybatisplus.plugins.Page;

@SuppressWarnings("serial")
public class PageUtils<T> extends Page<T> {

		public PageUtils(int current, int size, String orderByField) {
			super((current+size)/size, size);
			this.setOrderByField(orderByField);
	}
}
