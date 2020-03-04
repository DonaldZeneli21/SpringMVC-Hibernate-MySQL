package com.myproject.dao;

import java.util.List;

import com.myproject.model.Destination;

public interface DestinationDao {

	public List<Destination> getDestination();

	public Long insertDestination(Destination destination);

	public Destination getById(long id);

	public void updateDestination(long id, Destination destination);

	public void deleteDestination(long id);

	
	// Named query and HQL
	public List<Destination> orderCountryNames();
	public List<Destination> search( String keyword);
	public List<Destination> destinationTravel();
	// Criteria Query for pagination
	public List<Destination> getPagedDestinations(Integer pageNo, Integer pageSize);

}
