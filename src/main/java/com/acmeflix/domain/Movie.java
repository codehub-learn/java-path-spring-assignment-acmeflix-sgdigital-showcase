package com.acmeflix.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "MOVIES", indexes = {@Index(columnList = "duration_in_minutes")})
@SequenceGenerator(name = "idGenerator", sequenceName = "MOVIES_SEQ", initialValue = 1, allocationSize = 1)
public class Movie extends Content {
	@Column(name = "duration_in_minutes", nullable = false)
	private Integer durationInMinutes;
}
