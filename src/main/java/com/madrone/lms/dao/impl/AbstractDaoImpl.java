package com.madrone.lms.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

import com.madrone.lms.dao.AbstractDao;

public abstract class AbstractDaoImpl <E, I extends Serializable> 
	implements AbstractDao<E,I> {
	
	@Autowired
    private SessionFactory sessionFactory;
	private Class<E> entityClass;
	
	protected AbstractDaoImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }
	
	@SuppressWarnings("unchecked")
	@Override
    public E findById(I id) {
        return (E) getCurrentSession().get(entityClass, id);
    }
 
    @Override
    public void saveOrUpdate(E e) {
        getCurrentSession().saveOrUpdate(e);
    }
    
    @Override
    public void save(E e) {
    	getCurrentSession().save(e);
    }
  
    @Override
    public void delete(E e) {
        getCurrentSession().delete(e);
    }
    
    @Override
    public void update(E e) {
        getCurrentSession().update(e);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<E> findByCriteria(List<Criterion> criterions) {
	    Criteria criteria = getCurrentSession().createCriteria(entityClass);
	    for(Criterion c : criterions) {
	            criteria.add(c);
	    }
    return criteria.list();
}
    
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    
   //Getting desending Order Lists.
    @SuppressWarnings("unchecked")
	public List<E> getOrderList(List<Criterion> criterions,String field) {
    	
    	Criteria criteria = getCurrentSession().createCriteria(entityClass);
	    for(Criterion c : criterions) {
	            criteria.add(c);
	            criteria.addOrder(Order.desc(field));
	    }
	    return criteria.list();
    }
}
