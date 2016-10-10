/**
 *
 */
package com.sso.sys.common.constants;


import java.util.Date;

import com.sso.sys.common.enums.DateFormatEnum;
import com.sso.sys.common.utils.DateUtils;

/**
 * @author Administrator
 */
public class ApplicationProperties {
    /**
     * js版本号
     */
    public static String jsVersion = DateUtils.format(new Date(), DateFormatEnum.yyyyMMddHHmm);
    /**
     * LOGIN_URL 重定向地址
     */
    public static String loginUrl = "";
    /**
     *  返回默认卡密管理地址
     */
    public static String loginReturnUrl="";
    
    public static String syzsLoginUrl="";
    /**
     * comebackUrl 重定向,回调地址
     */
    public static String comebackUrl = "";

    /**
     * 财务服务地址
     */
    public static String financeServer;

    /**
     * 基础类地址
     */
    public static String catoryServer;

    /**
     * 主站地址
     */
    public static String mainServer;
    /**
     * 下载模板title
     */
    public static String templateData;

    public static String gameInfo;


    public static String cardFaceServer;

    /**
     * comebackUrl 重定向,回调地址
     */
    public static String countryUrl = "";

    /**
     * 财务手续费账户
     */
    public static String financeFeeAccount;
    /**
     * 发货订单提醒用户列表
     */
    public static String deliveryOrderWarnMailList;
    /**
     * 发货订单提醒标识 1：开启 0:关闭
     */
    public static String deliveryOrderWarn;
}
