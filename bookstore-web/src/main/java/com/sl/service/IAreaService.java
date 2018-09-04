package com.sl.service;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sl.entity.Area;

public interface IAreaService {
	
	List<Area> getAreaList() throws JsonProcessingException, IOException; 
}
