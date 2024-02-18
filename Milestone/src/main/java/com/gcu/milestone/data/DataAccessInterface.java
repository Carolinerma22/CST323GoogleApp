package com.gcu.milestone.data;

import java.util.List;

//allow it to take generics as a type
public interface DataAccessInterface <T> {
	public List<T> findAll();
	public T findById(Long id);
	public boolean create(T t);
	public boolean update(T t);
	public boolean deleteByID(Long id);
}