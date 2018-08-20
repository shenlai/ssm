package com.sl.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sl.entity.HeadLine;

public interface IHeadLineService {
	
	List<HeadLine> getHeadLineList(@Param("headLineCondition") HeadLine headLineCondition);

}
