package org.sso.sys.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.liebao.lb7881.common.utils.UUIDUtils;


/**
 * Unit test for simple App.
 */

public class UserTest{
	
	public void queryUser(){
		Map<String, Object> map = null; 
		List<Map<String,Object>> listMap = new ArrayList<Map<String, Object>>();
		map =  new HashMap<String, Object>();
		map.put("id", UUIDUtils.randomUUID());
		map.put("name", "lihua");
		listMap.add(map);
		map =  new HashMap<String, Object>();
		map.put("id", UUIDUtils.randomUUID());
		map.put("name", "lisa");
		listMap.add(map);
		
		for (Map<String, Object> m : listMap) {
			for (String key : m.keySet()) {
				System.out.println( key + m.get(key));
			}
		}
	}
   
	
	public static void main(String[] args) {
		Map<String, Object> map = null; 
		List<Map<String,Object>> listMap = new ArrayList<Map<String, Object>>();
		map =  new HashMap<String, Object>();
		map.put("id", UUIDUtils.randomUUID());
		map.put("name", "lihua");
		System.out.println(JSON.toJSONString(map));
		
		Set<String> set = map.keySet();
		System.out.println(JSON.toJSONString(set)+" key set  ");
	 
		listMap.add(map);
		map =  new HashMap<String, Object>();
		map.put("id", UUIDUtils.randomUUID());
		map.put("name", "lisa");
		System.out.println(JSON.toJSONString(map));
		listMap.add(map);
		System.out.println(JSON.toJSONString(listMap));
		for (Map<String, Object> m : listMap) {
			for (String key : m.keySet()) {
				System.out.println( key +"  : "+ m.get(key));
			}
		}
		
		
		
		  Set<String> LOGIN_WHITE_LIST = new HashSet<String>(){
			    {
			        add("/shipment/orderPlace.htm");
			        add("/base/ajax/getGroups.htm");
			        add("/base/ajax/getService.htm");
			        add("/shipment/ajax/orderPlaceTrade.htm");
			    }
			} ;
			
			for (String string : LOGIN_WHITE_LIST) {
				if(string.contains("/shipment/ajax/orderPlaceTrade.htm")){
					System.out.println(string);
				}
			}
			
	}
	
}
