package com.acmeflix.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "TV_SHOWS")
@SequenceGenerator(name = "idGenerator", sequenceName = "TV_SHOWS_SEQ", initialValue = 1, allocationSize = 1)
public class TvShow extends Content {
	private Set<Season> seasons = new HashSet<>();
}
