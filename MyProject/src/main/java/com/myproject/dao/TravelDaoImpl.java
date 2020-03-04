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

import com.myproject.model.Travel;

@Repository
public class TravelDaoImpl implements TravelDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Travel> getTravel() {

		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Travel> cq = cb.createQuery(Travel.class);
		Root<Travel> root = cq.from(Travel.class);
		cq.select(root);
		Query<Travel> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public Long insertTravel(Travel travel) {

		sessionFactory.getCurrentSession().save(travel);
		return travel.getIdTravel();
	}

	@Override
	public Travel getById(long id) {
		
		return sessionFactory.getCurrentSession().get(Travel.class, id);
	}

	@Override
	public void updateTravel(long id, Travel travel) {
		
		Session session = sessionFactory.getCurrentSession();
		Travel travel2 = session.byId(Travel.class).load(id);
		travel2.setDateFrom(travel.getDateFrom());
		travel2.setDateTo(travel.getDateTo());
		travel2.setDestination(travel.getDestination());
		travel2.setReservations(travel.getReservations());
		session.flush();
	}

	@Override
	public void deleteTravel(long id) {
		
		Session session = sessionFactory.getCurrentSession();
		Travel travel = session.byId(Travel.class).load(id);
	    session.delete(travel);
	}

}
