package com.myproject.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.model.Tourist;

@Repository
public class TouristDaoImpl implements TouristDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Tourist> getTourist() {

		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Tourist> cq = cb.createQuery(Tourist.class);
		Root<Tourist> root = cq.from(Tourist.class);
		cq.select(root);
		Query<Tourist> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public Long insertTourist(Tourist tourist) {

		sessionFactory.getCurrentSession().save(tourist);
		return tourist.getIdTourist();
	}

	@Override
	public Tourist getById(long id) {
		
		return sessionFactory.getCurrentSession().get(Tourist.class, id);
	}

	@Override
	public void updateTourist(long id, Tourist tourist) {
		
		Session session = sessionFactory.getCurrentSession();
		Tourist tourist2 = session.byId(Tourist.class).load(id);
		tourist2.setTouristName(tourist.getTouristName());
		tourist2.setTouristSurname(tourist.getTouristSurname());
		tourist2.setTouristBirthdate(tourist.getTouristBirthdate());
		tourist2.setTouristEmail(tourist.getTouristEmail());
		tourist2.setReservations(tourist.getReservations());
		session.flush();
	}

	@Override
	public void deleteTourist(long id) {
		
		Session session = sessionFactory.getCurrentSession();
		Tourist tourist = session.byId(Tourist.class).load(id);
	    session.delete(tourist);
	}

}
