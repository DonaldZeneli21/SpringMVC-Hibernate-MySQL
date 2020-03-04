package com.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dao.AccomodationDao;
import com.myproject.model.Accomodation;

@Service
@Transactional(readOnly = true)
public class AccomodationServiceImpl implements AccomodationService{

	@Autowired
	private AccomodationDao dao;
	
	@Override
	public List<Accomodation> getAccomodation() {
		
		return dao.getAccomodation();
	}

	@Override
	@Transactional
	public Long insertAccomodation(Accomodation accomodation) {
	
		return dao.insertAccomodation(accomodation);
	}

	@Override
	public Accomodation getById(long id) {
		
		return dao.getById(id);
	}

	@Override
	@Transactional
	public void updateAccomodation(long id, Accomodation accomodation) {
		
		dao.updateAccomodation(id, accomodation);
	}

	@Override
	@Transactional
	public void deleteAccomodation(long id) {
		
		dao.deleteAccomodation(id);
	}

	@Override
	public List<Accomodation> getHotelType() {
		
		return dao.getHotelType();
	}

	@Override
	public List<Accomodation> searchAccomodationByType(String keyword) {
		
		return dao.searchAccomodationByType(keyword);
	}

	@Override
	public List<Accomodation> getAccomByCriteriaQuery() {
		
		return dao.getAccomByCriteriaQuery();
	}

}
