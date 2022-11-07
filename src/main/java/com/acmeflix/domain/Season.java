package com.acmeflix.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "SEASONS", indexes = {@Index(columnList = "title"), @Index(columnList = "release_year")})
@SequenceGenerator(name = "idGenerator", sequenceName = "SEASONS_SEQ", initialValue = 1, allocationSize = 1)
public class Season extends BaseModel {
	@Column(nullable = false, length = 50)
	private String title;

	@Column(nullable = false)
	private Integer ordering;

	@Column(name = "release_year", nullable = false)
	private Integer releaseYear;

	@Builder.Default
	@OneToMany(mappedBy = "season", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Episode> episodes = new HashSet<>();

	@ToString.Exclude
	@ManyToOne(optional = false)
	private TvShow tvShow;
}
