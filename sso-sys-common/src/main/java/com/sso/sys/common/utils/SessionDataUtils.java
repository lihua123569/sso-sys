/**
 * 江苏猎宝网络科技有限公司
 * 
 * 项目名称 : shouyouzhushou-common
 * 创建日期 : 2016年9月25日
 * 修改历史 : 
 *     1. [2016年9月25日] 创建文件 by xupan
 */
package com.sso.sys.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sso.sys.common.bean.SessionData;

/**
 * SessionData工具管理类
 */
public class SessionDataUtils {
    /**
     * session数据对象key
     */
    private static final String SESSION_DATA_ATTR_NAME = "user";
    
    
    public static SessionData getSessionData(HttpServletRequest request){
        
        HttpSession session = request.getSession();
        
        SessionData sessionData = (SessionData)session.getAttribute(SESSION_DATA_ATTR_NAME);
        
        return sessionData;
    }
    /**
     * 设置sessionData
     * TODO 添加方法功能描述
     * @param request
     * @param sessionData
     */
    public static void setSessionData(HttpServletRequest request,SessionData sessionData){
        
        HttpSession httpSession = request.getSession();
        
        httpSession.setAttribute(SESSION_DATA_ATTR_NAME, sessionData);
    }

}
