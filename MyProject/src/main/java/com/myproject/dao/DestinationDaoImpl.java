package com.myproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myproject.model.Destination;

@Repository
public class DestinationDaoImpl implements DestinationDao {

	@Autowired
	private SessionFactory sessionFactory;

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Destination> getDestination() {

		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Destination> cq = cb.createQuery(Destination.class);
		Root<Destination> root = cq.from(Destination.class);
		cq.select(root);
		Query<Destination> query = session.createQuery(cq);
		return query.getResultList();

	}

	@Override
	public Long insertDestination(Destination destination) {
		sessionFactory.getCurrentSession().save(destination);
		return destination.getIdDestination();
	}

	@Override
	public Destination getById(long id) {

		return sessionFactory.getCurrentSession().get(Destination.class, id);
	}

	@Override
	public void updateDestination(long id, Destination destination) {

		Session session = sessionFactory.getCurrentSession();
		Destination destination2 = session.byId(Destination.class).load(id);
		destination2.setCountryName(destination.getCountryName());
		destination2.setCityName(destination.getCityName());
		session.flush();
	}

	@Override
	public void deleteDestination(long id) {

		Session session = sessionFactory.getCurrentSession();
		Destination destination = session.byId(Destination.class).load(id);
		session.delete(destination);

	}


	
	@SuppressWarnings("unchecked")
	@Override
	public List<Destination> orderCountryNames() {
		
		String hql = "Select d.countryName From Destination d order by d.countryName";
		Query<Destination> query =  sessionFactory.getCurrentSession().createQuery(hql);
		List<Destination> results = query.getResultList();
		
		return results;
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Destination> search(String keyword) {
		
		Query<Destination> query = sessionFactory.getCurrentSession().getNamedQuery(Destination.SEARCH_KEYWORD);
		query.setParameter("keyword", keyword);
		List<Destination> list = query.getResultList();

		return list;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Destination> destinationTravel() {

		Query<Destination> query = sessionFactory.getCurrentSession().getNamedQuery(Destination.JOIN_TABLES);
		List<Destination> list = query.getResultList();
		return list;
	
	}

	@Override
	public List<Destination> getPagedDestinations(Integer pageNo, Integer pageSize) {
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Destination> cq = cb.createQuery(Destination.class);
		Root<Destination> root = cq.from(Destination.class);
		cq.select(root);
		
		Query<Destination> query = session.createQuery(cq);
		
		query.setFirstResult((pageNo - 1) * pageSize);
        query.setMaxResults(pageSize); 
     
        List<Destination> employees = query.getResultList();
		return employees;
	}
	
	@Override
	public List<Destination> getPagedDestinationsWithOrder(Integer pageNo, Integer pageSize, String sortBy) {
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Destination> cq = cb.createQuery(Destination.class);
		Root<Destination> root = cq.from(Destination.class);
		cq.select(root).orderBy(cb.asc(root.get(sortBy)));

		Query<Destination> query = session.createQuery(cq);
		
		query.setFirstResult((pageNo - 1) * pageSize);
        query.setMaxResults(pageSize); 
     
        List<Destination> destinations = query.getResultList();
		return destinations;
	}
}