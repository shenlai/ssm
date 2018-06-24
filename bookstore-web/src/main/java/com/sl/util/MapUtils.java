package com.sl.util;

import java.lang.reflect.Field;
import java.util.HashMap;

public class MapUtils {
	
	 public static HashMap<String, Object> returnMap(Object pojo){
		 
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		Field f1[] = null;
		Field f2[] = null;
		
		f1 = pojo.getClass().getDeclaredFields();
		f2 = pojo.getClass().getSuperclass().getDeclaredFields();
		
		Field field[] = new Field[f1.length+f2.length];
		
		for(int i = 0;i < f1.length;i++){
			field[i] = f1[i];
		}
		
		for(int j = 0;j < f2.length;j++){
			field[j+f1.length] = f2[j];
		}
		
		for(Field f : field){
			
			String key = f.getName();
			Object obj = null;
			try {
				f.setAccessible(true);
				obj = f.get(pojo);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			hashMap.put(key,obj);
		}
		
		return hashMap;
	 }
	 

}