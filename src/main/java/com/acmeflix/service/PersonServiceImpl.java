package com.acmeflix.service;

import com.acmeflix.domain.Person;
import com.acmeflix.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {
	private final PersonRepository personRepository;

	@Override
	public JpaRepository<Person, Long> getRepository() {
		return personRepository;
	}

	@Override
	public Person getFullContent(final Long id) {
		return personRepository.getFullContent(id);
	}

	@Override
	public Person findByLastNameAndFirstName(final String lastName, final String firstName) {
		return personRepository.findByLastNameAndFirstName(lastName, firstName);
	}
}
