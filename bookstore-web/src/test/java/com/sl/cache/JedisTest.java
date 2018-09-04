package com.sl.cache;

import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sl.BaseTest;
import com.sl.dao.AreaDao;
import com.sl.dao.ProductDao;
import com.sl.entity.Area;
import com.sl.entity.Product;
import com.sl.util.KeyCreator;

import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JedisTest  extends BaseTest {
	
	@Autowired
	private JedisUtil jedisUtil;
	@Autowired
	private JedisUtil.Strings jedisStrings;
	@Autowired
	private JedisUtil.Lists jedisLists;
	@Autowired
	private JedisUtil.Keys jedisKeys;

	@Autowired
	private ProductDao productDao;
	
	@Test
	public void testLists() throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<Product> proList = new ArrayList<Product>();
		Product productCondition = new Product();
		//productCondition.setEnableStatus(1);
		proList = productDao.queryProductList(productCondition, 1, 50);
		String jsonString = mapper.writeValueAsString(proList);
		String key = KeyCreator.create(productCondition);
		jedisStrings.set(key, jsonString);
		
		jedisLists.lpush("ListType"+key, mapper.writeValueAsString(proList.get(0)));
		jedisLists.lpush("ListType"+key, mapper.writeValueAsString(proList.get(1)));
		jedisLists.lpush("ListType"+key, mapper.writeValueAsString(proList.get(2)));
		jedisLists.lpush("ListType"+key, mapper.writeValueAsString(proList.get(3)));
		
		String index2Value = jedisLists.lindex("ListType"+key, 2);
		
		System.out.println(index2Value);
	}
	

}
