package com.dev;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentHashMapDemo {
	public static void main(String[] args) {
		ConcurrentMap<String, Object> map=new ConcurrentHashMap<String, Object>();
		map.put("a", "aa");
		map.put("b", "bb");
		/**
		 *  if (!map.containsKey(key))
   			return map.put(key, value);
 			else
   			return map.get(key);
		 * */  
		Object object=map.putIfAbsent("b", "BB");
		System.out.println(object);
		System.out.println(map.size());
	}
	

}
