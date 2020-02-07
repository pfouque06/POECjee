package org.eclipse.Dao;

import java.util.List;

public interface GenericDao <T> {
	T save(T obj);

	T remove(int id);

	T update(T obj);

	T findById(int id);

	List<T> getAll();
	
	boolean validate(T o);
}
