package com.acmeflix.service;

import com.acmeflix.domain.BaseModel;

import java.util.List;

public interface BaseService<T extends BaseModel, Ι> {
	T create(final T item);

	List<T> createAll(final T... items);

	List<T> createAll(final List<T> items);

	void update(T item);

	void delete(T item);

	void deleteById(Ι id);

	boolean exists(T item);

	T get(Ι id);

	List<T> findAll();

	Long count();
}
