package com.sl.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sl.BaseTest;
import com.sl.entity.Area;
import com.sl.entity.HeadLine;

public class HeadLineDaoTest extends BaseTest{
	
	@Autowired
	private HeadLineDao headLineDao;
	
	@Test
	public void testQueryHeadLine() throws Exception {
		HeadLine headLineCondition = new HeadLine();
		
		List<HeadLine> list = headLineDao.queryHeadLine(headLineCondition);
		assertTrue(list.size()>0);
	}

}