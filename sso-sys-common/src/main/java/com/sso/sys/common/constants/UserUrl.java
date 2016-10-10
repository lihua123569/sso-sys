/**
 * 江苏猎宝网络科技有限公司
 * 
 * 项目名称 : shouhuo-service-common
 * 创建日期 : 2016年7月11日
 * 修改历史 : 
 *     1. [2016年7月11日] 创建文件 by xupan
 */
package com.sso.sys.common.constants;

/**
 * 主站用户接口URL常量类
 */
public class UserUrl {
    
    /**
     * 获取用户信息
     */
    public static final String GET_USER = ApplicationProperties.mainServer+"user/insideByUserid.action"; 
    
    /**
     * 获取用户权限
     */
    public static final String QUERY_ROLE = ApplicationProperties.catoryServer+"api/querySup7881merchant";//?splx=11&userid=117800766";
  
    /**
     * 获取基础类信息
     */
    public static final String GET_GAME_INFO = ApplicationProperties.catoryServer+"gameInfo/";
    
    /**
     * 登录 url
     */
    public static final String GET_LOGIN_URL = ApplicationProperties.loginUrl;
   
    /**
     *  登录返回 url
     */
    public static final String GET_COME_BACK_URL = ApplicationProperties.comebackUrl;

    /**
     * 返回默认卡密管理地址
     */
    public static final String GET_LOGIN_RETURN_URL = ApplicationProperties.loginReturnUrl;
    
}
