package com.myproject.dao;

import java.util.List;

import com.myproject.model.Tourist;

public interface TouristDao {

	public List<Tourist> getTourist();

	public Long insertTourist(Tourist tourist);

	public Tourist getById(long id);
	
	public void updateTourist(long id, Tourist tourist);

	public void deleteTourist(long id);

}
