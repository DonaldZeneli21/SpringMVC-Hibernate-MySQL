package com.myproject.dao;

import java.util.List;

import com.myproject.model.Reservation;

public interface ReservationDao {

	public List<Reservation> getReservation();

	public Long insertReservation(Reservation reservation);

	public Reservation getById(long id);
	
	public void updateReservation(long id, Reservation reservation);

	public void deleteReservation(long id);
	
	
	// Named query and HQL 
	public List<Reservation> getCanceledReservation();
}
