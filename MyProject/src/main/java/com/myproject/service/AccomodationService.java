package com.myproject.service;

import java.util.List;

import com.myproject.model.Accomodation;

public interface AccomodationService {

	public List<Accomodation> getAccomodation();

	public Long insertAccomodation(Accomodation accomodation);

	public Accomodation getById(long id);
	
	public void updateAccomodation(long id, Accomodation accomodation);

	public void deleteAccomodation(long id);
	
	
	//Named query and HQL
	public List<Accomodation> getHotelType();
	public List<Accomodation> searchAccomodationByType( String keyword);
	public List<Accomodation> getAccomByCriteriaQuery();
}
