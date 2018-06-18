package com.sl.test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sl.po.Product;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


import org.junit.Test;

public class TestClient {

	// 定义SqlSession
	SqlSession session = null;
	 ApplicationContext context = null;
	
	@Before
	public void init() throws IOException {
		
		//context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
		
		// 定义mabatis全局配置文件
		String resource = "spring/applicationContext-dao.xml";
		//String resource = "D:/JavaProject/bookstore/ssm/bookstore-web/src/main/resources/spring/applicationContext-dao.xml";

		URL url = TestClient.class.getClassLoader().getResource("spring/applicationContext-dao.xml");
		// 加载mybatis全局配置文件
		 InputStream inputStream = TestClient.class.getClassLoader().getResourceAsStream(resource);

		//InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(inputStream);
		// 根据sqlSessionFactory产生session
		session = factory.openSession();
	}

	// 查询所有user表所有数据
	@Test
	public void testSelectAllUser() {
		String statement = "com.sl.po.productMapper.selectAllProduct";
		List<Product> listProduct = session.selectList(statement);
		for (Product product : listProduct) {
			System.out.println(product);
		}
		session.close();
	}
}
