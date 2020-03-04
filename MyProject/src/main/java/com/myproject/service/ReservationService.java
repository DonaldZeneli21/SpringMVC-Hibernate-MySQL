package com.myproject.service;

import java.util.List;

import com.myproject.model.Reservation;

public interface ReservationService {

	public List<Reservation> getReservation();

	public Long insertReservation(Reservation reservation);

	public Reservation getById(long id);
	
	public void updateReservation(long id, Reservation reservation);

	public void deleteReservation(long id);
	
	// Get Cancelled Reservations 
	public List<Reservation> getCanceledReservation();
}
