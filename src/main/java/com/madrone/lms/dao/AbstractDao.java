package com.madrone.lms.dao;

import java.util.List;

import org.hibernate.criterion.Criterion;

import com.madrone.lms.entity.Leave;

public interface AbstractDao<E, I> {
	
	public E findById(I id);
	
	public void saveOrUpdate(E e);
	
	public void save(E e);
	
	public void delete(E e);
	
	public void update(E e);
	
	public List<E> findByCriteria(List<Criterion> criterions);
	
	public List<E> getOrderList(List<Criterion> criterions,String field);
	
}
