package com.acmeflix.service;

import com.acmeflix.domain.BaseModel;

import java.util.List;

public interface BaseService<T extends BaseModel, I> {
	T create(final T item);

	List<T> createAll(final T... items);

	List<T> createAll(final List<T> items);

	void update(T item);

	void delete(T item);

	void deleteById(I id);

	boolean exists(T item);

	T get(I id);

	List<T> findAll();
}
