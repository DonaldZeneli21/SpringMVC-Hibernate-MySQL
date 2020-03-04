package com.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.dao.ReservationDao;
import com.myproject.model.Reservation;

@Service
@Transactional(readOnly = true)
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationDao dao;
	
	@Override
	public List<Reservation> getReservation() {
	
		return dao.getReservation();
	}

	@Override
	@Transactional
	public Long insertReservation(Reservation reservation) {

		return dao.insertReservation(reservation);
	}

	@Override
	public Reservation getById(long id) {
		
		return dao.getById(id);
	}

	@Override
	@Transactional
	public void updateReservation(long id, Reservation reservation) {
	
		dao.updateReservation(id, reservation);
	}

	@Override
	@Transactional
	public void deleteReservation(long id) {
	
		dao.deleteReservation(id);
	}

	@Override
	public List<Reservation> getCanceledReservation() {
		
		return dao.getCanceledReservation();
	}

}
