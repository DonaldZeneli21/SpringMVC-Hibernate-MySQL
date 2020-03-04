package com.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.myproject.dao.TouristDao;
import com.myproject.model.Tourist;

@Service
@Transactional(readOnly = true)
public class TouristServiceImpl implements TouristService{

	@Autowired
	private TouristDao dao;
	
	@Override
	public List<Tourist> getTourist() {
		
		return dao.getTourist();
	}

	@Override
	@Transactional
	public Long insertTourist(Tourist tourist) {
		
		return dao.insertTourist(tourist);
	}

	@Override
	public Tourist getById(long id) {
		
		return dao.getById(id);
	}

	@Override
	@Transactional
	public void updateTourist(long id, Tourist tourist) {
		
		dao.updateTourist(id, tourist);
	}

	@Override
	@Transactional
	public void deleteTourist(long id) {
		
		dao.deleteTourist(id);
	}

}
