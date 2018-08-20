package com.sl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sl.dao.AreaDao;
import com.sl.dao.HeadLineDao;
import com.sl.entity.HeadLine;
import com.sl.service.IHeadLineService;

@Service
public class HeadLineService implements IHeadLineService{

	
	@Autowired
	private HeadLineDao headLineDao;
	
	
	@Override
	public List<HeadLine> getHeadLineList(HeadLine headLineCondition) {
		
		return headLineDao.queryHeadLine(headLineCondition);
	}
	

}
