package com.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dao.TravelDao;
import com.myproject.model.Travel;

@Service
@Transactional(readOnly = true)
public class TravelServiceImpl implements TravelService{

	@Autowired
	private TravelDao dao;
	
	@Override
	public List<Travel> getTravel() {
		
		return dao.getTravel();
	}

	@Override
	@Transactional
	public Long insertTravel(Travel travel) {
		
		return dao.insertTravel(travel);
	}

	@Override
	public Travel getById(long id) {
		
		return dao.getById(id);
	}

	@Override
	@Transactional
	public void updateTravel(long id, Travel travel) {
		
		dao.updateTravel(id, travel);
	}

	@Override
	@Transactional
	public void deleteTravel(long id) {
		
		dao.deleteTravel(id);
	}

}
