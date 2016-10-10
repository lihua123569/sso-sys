package com.sso.sys.common.utils;

import com.alibaba.fastjson.JSON;

import java.util.Map;
/**
 * 
 * IOS报文工具类
 */
public class IOSMessageUtils {
    /**
     * IOS类JSON报文转换成Map
     * @param message
     * @return
     */
    public static Map<String, Object> message2Map(String message){
        
        message = message.replaceAll(" = ", ":").replace(";", ",");
        
        @SuppressWarnings("unchecked")
        Map<String, Object> map = JSON.parseObject(message,Map.class);
        
        return map;
    }
}
