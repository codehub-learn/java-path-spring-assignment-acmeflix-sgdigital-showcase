package com.acmeflix.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "EPISODES", indexes = {@Index(columnList = "title"), @Index(columnList = "duration_in_minutes")})
@SequenceGenerator(name = "idGenerator", sequenceName = "EPISODES_SEQ", initialValue = 1, allocationSize = 1)
public class Episode extends BaseModel implements Serializable {
	@Column(nullable = false, length = 50)
	private String title;

	private String summary;

	@Column(name = "duration_in_minutes", nullable = false)
	private Integer durationInMinutes;

	@ToString.Exclude
	@ManyToOne(optional = false)
	private Season season;
}
