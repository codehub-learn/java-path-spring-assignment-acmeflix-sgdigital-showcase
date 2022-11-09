package com.acmeflix.service;

import com.acmeflix.domain.Person;

public interface PersonService extends BaseService<Person, Long> {
	Person getFullContent(Long id);

	Person findByLastNameAndFirstName(String lastName, String firstName);
}
