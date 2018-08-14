package com.sl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.dao.AreaDao;
import com.sl.entity.Area;
import com.sl.service.IAreaService;

@Service
public class AreaService implements IAreaService {

	@Autowired
	private AreaDao areaDao;
	
	@Override
	public List<Area> getAreaList() {
		
		return areaDao.queryArea();
	}

}
