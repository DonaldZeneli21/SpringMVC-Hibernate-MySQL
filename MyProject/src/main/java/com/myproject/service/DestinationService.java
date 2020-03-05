package com.myproject.service;

import java.util.List;

import com.myproject.model.Destination;

public interface DestinationService {

	public List<Destination> getDestination();

	public Long insertDestination(Destination destination);

	public Destination getById(long id);
	
	void updateDestination(long id, Destination destination);

	void deleteDestination(long id);
	
	
	///test

	public List<Destination> orderCountryNames();
	public List<Destination> search( String keyword);
	public List<Destination> destinationTravel();
	
	public List<Destination> getPagedDestinations(Integer pageNo, Integer pageSize);
	
	List<Destination> getPagedDestinationsWithOrder(Integer pageNo, Integer pageSize, String sortBy);

}
