package com.myproject.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.model.Reservation;

@Repository
public class ReservationDaoImpl implements ReservationDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Reservation> getReservation() {

		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Reservation> cq = cb.createQuery(Reservation.class);
		Root<Reservation> root = cq.from(Reservation.class);
		cq.select(root);
		Query<Reservation> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public Long insertReservation(Reservation reservation) {

		sessionFactory.getCurrentSession().save(reservation);
		return reservation.getIdReservation();
	}

	@Override
	public Reservation getById(long id) {
		
		return sessionFactory.getCurrentSession().get(Reservation.class, id);
	}

	@Override
	public void updateReservation(long id, Reservation reservation) {
		
		Session session = sessionFactory.getCurrentSession();
		Reservation reservation2 = session.byId(Reservation.class).load(id);
		reservation2.setReservationDate(reservation.getReservationDate());
		reservation2.setFlagCancelled(reservation.isFlagCancelled());
		reservation2.setCancelDate(reservation.getCancelDate());
		reservation2.setAccomodation(reservation.getAccomodation());
		reservation2.setTourist(reservation.getTourist());
		reservation2.setTravel(reservation.getTravel());
		session.flush();
	}

	@Override
	public void deleteReservation(long id) {
		
		Session session = sessionFactory.getCurrentSession();
		Reservation reservation = session.byId(Reservation.class).load(id);
	    session.delete(reservation);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> getCanceledReservation() {
		
		Query<Reservation> query = sessionFactory.getCurrentSession().getNamedQuery(Reservation.CANCELED_RESERVATION);
		List<Reservation> list = query.getResultList();
		return list;
	}

}
