package com.myproject.dao;

import java.util.List;

import com.myproject.model.Travel;

public interface TravelDao {

	public List<Travel> getTravel();

	public Long insertTravel(Travel travel);

	public Travel getById(long id);
	
	public void updateTravel(long id, Travel travel);

	public void deleteTravel(long id);
}
