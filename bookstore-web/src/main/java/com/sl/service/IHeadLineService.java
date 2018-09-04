package com.sl.service;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sl.entity.HeadLine;

public interface IHeadLineService {
	
	List<HeadLine> getHeadLineList(@Param("headLineCondition") HeadLine headLineCondition)throws JsonParseException, JsonMappingException, IOException;

}
