package com.acmeflix.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "PERSONS")
@SequenceGenerator(name = "idGenerator", sequenceName = "PERSONS_SEQ", initialValue = 1, allocationSize = 1)
public class Person extends BaseModel {
	@Column(name = "first_name", length = 20)
	private String firstName;

	@Column(name = "last_name", length = 30)
	private String lastName;
}
