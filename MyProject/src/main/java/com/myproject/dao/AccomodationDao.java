package com.myproject.dao;

import java.util.List;
import com.myproject.model.Accomodation;

public interface AccomodationDao{

	public List<Accomodation> getAccomodation();

	public Long insertAccomodation(Accomodation accomodation);

	public Accomodation getById(long id);
	
	public void updateAccomodation(long id, Accomodation accomodation);

	public void deleteAccomodation(long id);
	
	//Named query and HQL
	public List<Accomodation> getHotelType();
	public List<Accomodation> searchAccomodationByType( String keyword);
	
	//Criteria Query
	public List<Accomodation> getAccomByCriteriaQuery();

}
