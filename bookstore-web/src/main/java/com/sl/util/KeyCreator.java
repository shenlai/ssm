package com.sl.util;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;

import com.sl.entity.Area;
import com.sl.entity.HeadLine;
public class KeyCreator {
	
	public static String create(Object object) throws Exception {
		try {
			Map<String, Object> map = new HashMap<String, Object>();

			Field[] fields = object.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				String fieldName = field.getName();
				Object value = field.get(object);
				map.put(fieldName, value);
			}

			List<String> keyList = new ArrayList<>(map.keySet());
			Collections.sort(keyList);

			StringBuilder sBuilder = new StringBuilder();
			for (String key : keyList) {
				Object value = map.get(key);
				if (value != null) {
					sBuilder.append(key);
					sBuilder.append("=");
					sBuilder.append(value);
					sBuilder.append("&");
				}
			}

			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] bys = md5.digest(sBuilder.toString().getBytes("utf-8"));
			String md5Key = Base64.encodeBase64String(bys);

			return object.getClass() + md5Key;
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}

	}
	
	
	public static void main(String[] args) {
		try {
			HeadLine con = new HeadLine();
			con.setEnableStatus(1);
			System.out.println(KeyCreator.create(con));
			System.out.println(KeyCreator.create(con));
			
			HeadLine conDefaut = new HeadLine();
			System.out.println(KeyCreator.create(conDefaut));
			
			System.out.println(KeyCreator.create(new Area()));

			System.out.println(KeyCreator.create(null));
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}


}
