package com.acmeflix.controller;

import com.acmeflix.base.BaseMapper;
import com.acmeflix.domain.Person;
import com.acmeflix.mapper.PersonMapper;
import com.acmeflix.service.BaseService;
import com.acmeflix.service.PersonService;
import com.acmeflix.transfer.resource.PersonResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController extends AbstractController<Person, PersonResource> {
	private final PersonService personService;
	private final PersonMapper personMapper;

	@Override
	public BaseService<Person, Long> getBaseService() {
		return personService;
	}

	@Override
	public BaseMapper<Person, PersonResource> getMapper() {
		return personMapper;
	}
}
