package com.sl.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sl.cache.JedisUtil;
import com.sl.dao.AreaDao;
import com.sl.entity.Area;
import com.sl.service.IAreaService;
import com.sl.util.KeyCreator;

@Service
public class AreaService implements IAreaService {

	@Autowired
	private JedisUtil.Strings jedisStrings;
	
	@Autowired
	private JedisUtil.Keys jedisKeys;
	
	@Autowired
	private AreaDao areaDao;

	@Override
	public List<Area> getAreaList() throws JsonProcessingException, IOException {
		
		List<Area> arealist = null;
		String areaListKey = "";
		try {
			areaListKey = KeyCreator.create(new Area());
			ObjectMapper mapper = new ObjectMapper();
			if(!jedisKeys.exists(areaListKey)) {
				arealist = areaDao.queryArea();
				String jsonStr = mapper.writeValueAsString(arealist);
				jedisStrings.set(areaListKey, jsonStr);
			}else {
				String jsonStr = jedisStrings.get(areaListKey);
				JavaType javaType = mapper.getTypeFactory().constructParametricType(ArrayList.class, Area.class);
				arealist = mapper.readValue(jsonStr, javaType);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return arealist;
	}

}
