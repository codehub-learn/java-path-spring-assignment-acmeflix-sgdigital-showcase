package com.acmeflix.service;

import com.acmeflix.domain.Person;

import java.util.List;

public interface PersonService extends BaseService<Person, Long> {
	List<Person> getFullContent();

	Person getFullContent(Long id);

	Person findByLastNameAndFirstName(String lastName, String firstName);
}
