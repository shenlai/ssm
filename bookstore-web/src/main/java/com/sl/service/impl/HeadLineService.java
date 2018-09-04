package com.sl.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sl.cache.JedisUtil;
import com.sl.dao.AreaDao;
import com.sl.dao.HeadLineDao;
import com.sl.entity.HeadLine;
import com.sl.service.IHeadLineService;
import com.sl.util.KeyCreator;

@Service
public class HeadLineService implements IHeadLineService{

	@Autowired
	private JedisUtil.Strings jedisStrings;
	@Autowired
	private JedisUtil.Keys jedisKeys;
	
	@Autowired
	private HeadLineDao  headLineDao;
	
	
	
	
	@Override
	public List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws JsonParseException, JsonMappingException, IOException {
		
		List<HeadLine> headLines = null;
		ObjectMapper objectMapper = new ObjectMapper();
		String key ="";                        
		try {
			key = KeyCreator.create(headLineCondition);
			if(jedisKeys.exists(key)) {
				String jsonStr = jedisStrings.get(key);
				JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, HeadLine.class);
				 headLines = objectMapper.readValue(jsonStr, javaType);
			}else {
				headLines = headLineDao.queryHeadLine(headLineCondition);
				String jsonStr = objectMapper.writeValueAsString(headLines);
				jedisStrings.set(key, jsonStr);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return headLines;
	}
	

}
