package com.acmeflix.service;

import com.acmeflix.domain.Person;
import com.acmeflix.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {
	private final PersonRepository personRepository;

	@Override
	public JpaRepository<Person, Long> getRepository() {
		return personRepository;
	}

	@Override
	public List<Person> findAll() {
		return getFullContent();
	}

	@Override
	public List<Person> getFullContent() {
		return personRepository.getFullContent();
	}

	@Override
	public Person getFullContent(final Long id) {
		return personRepository.getFullContent(id);
	}

	@Override
	public Person findByLastNameAndFirstName(final String lastName, final String firstName) {
		return personRepository.findByLastNameIgnoreCaseAndFirstNameIgnoreCase(lastName, firstName).stream().findFirst()
							   .orElseThrow();
	}
}
