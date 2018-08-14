package com.sl.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sl.BaseTest;
import com.sl.entity.Area;
import com.sl.service.impl.AreaService;

public class AreaServiceTest extends BaseTest{
	@Autowired
	private AreaService areaService;
	
	@Test
	public void testGetAreaList() throws Exception {
		List<Area> areaList = areaService.getAreaList();
		
		assertEquals(4, areaList.size());
	}

}
