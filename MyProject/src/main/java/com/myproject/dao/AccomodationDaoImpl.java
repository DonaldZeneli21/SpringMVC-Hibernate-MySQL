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

import com.myproject.model.Accomodation;

@Repository
public class AccomodationDaoImpl implements AccomodationDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Accomodation> getAccomodation() {

		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Accomodation> cq = cb.createQuery(Accomodation.class);
		Root<Accomodation> root = cq.from(Accomodation.class);
		cq.select(root);
		Query<Accomodation> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public Long insertAccomodation(Accomodation accomodation) {

		sessionFactory.getCurrentSession().save(accomodation);
		return accomodation.getIdAccomodation();
	}

	@Override
	public Accomodation getById(long id) {
		
		return sessionFactory.getCurrentSession().get(Accomodation.class, id);
	}

	@Override
	public void updateAccomodation(long id, Accomodation accomodation) {
		
		Session session = sessionFactory.getCurrentSession();
		Accomodation accomodation2 = session.byId(Accomodation.class).load(id);
		accomodation2.setAccomodationType(accomodation.getAccomodationType());
		accomodation2.setAddress(accomodation.getAddress());
		accomodation2.setRoomNumber(accomodation.getRoomNumber());
		accomodation2.setCost(accomodation.getCost());
		accomodation2.setReservations(accomodation.getReservations());
		session.flush();
	}

	@Override
	public void deleteAccomodation(long id) {
		
		Session session = sessionFactory.getCurrentSession();
		Accomodation accomodation = session.byId(Accomodation.class).load(id);
	    session.delete(accomodation);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Accomodation> getHotelType() {
		
		String hql = "Select a From Accomodation a Where a.accomodationType = 'Hotel'";
		Query<Accomodation> query =  sessionFactory.getCurrentSession().createQuery(hql);
		List<Accomodation> results = query.getResultList();
		
		return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Accomodation> searchAccomodationByType(String keyword) {
		
		Query<Accomodation> query = sessionFactory.getCurrentSession().getNamedQuery(Accomodation.DESTINATION_BY_ACCOMODATION);
		query.setParameter("keyword", keyword);
		List<Accomodation> list = query.getResultList();
		return list;
	}


	@Override
	public List<Accomodation> getAccomByCriteriaQuery() {
		
		CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
		CriteriaQuery<Accomodation> criteriaQuery = builder.createQuery(Accomodation.class);
		Root<Accomodation> root = criteriaQuery.from(Accomodation.class);
		criteriaQuery.select(root);
	
		Query<Accomodation> query = sessionFactory.getCurrentSession().createQuery(criteriaQuery);
		List<Accomodation> list = query.list();
		
		return list;
	}

}
