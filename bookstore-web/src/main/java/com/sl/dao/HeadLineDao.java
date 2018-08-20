package com.sl.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sl.entity.HeadLine;

public interface HeadLineDao {
	
	List<HeadLine> queryHeadLine(@Param("headLineCondition") HeadLine headLineCondition);

}
