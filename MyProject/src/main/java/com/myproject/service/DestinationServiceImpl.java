package com.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dao.DestinationDao;
import com.myproject.model.Destination;

@Service
@Transactional(readOnly = true)
public class DestinationServiceImpl implements DestinationService{

	@Autowired
	private DestinationDao dao;
	
	@Override
	public List<Destination> getDestination() {
		
		return dao.getDestination();
	}

	@Override
	@Transactional
	public Long insertDestination(Destination destination) {
		
		return dao.insertDestination(destination);
	}

	@Override
	public Destination getById(long id) {
		
		return dao.getById(id);
	}

	@Override
	@Transactional
	public void updateDestination(long id, Destination destination) {
	
		dao.updateDestination(id, destination);
	}

	@Override
	@Transactional
	public void deleteDestination(long id) {
		
		dao.deleteDestination(id);
	}


	

	@Override
	public List<Destination> orderCountryNames() {
	
		return dao.orderCountryNames();
	}



	@Override
	public List<Destination> search(String keyword) {
		
		return dao.search(keyword);
	}

	@Override
	public List<Destination> destinationTravel() {
		
		return dao.destinationTravel();
	}

	@Override
	public List<Destination> getPagedDestinations(Integer pageNo, Integer pageSize) {
		
		return dao.getPagedDestinations(pageNo, pageSize);
	}

	


}
