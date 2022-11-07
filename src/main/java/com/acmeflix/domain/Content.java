package com.acmeflix.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Table(name = "CONTENT", indexes = {@Index(columnList = "title"), @Index(columnList = "release_year")})
@SequenceGenerator(name = "idGenerator", sequenceName = "CONTENT_SEQ", initialValue = 1, allocationSize = 1)
@Inheritance(strategy = InheritanceType.JOINED)
public class Content extends BaseModel {
	@Column(nullable = false, length = 50)
	private String title;

	private String plot;

	@Column(name = "release_year", nullable = false)
	private Integer releaseYear;

	@Enumerated(EnumType.STRING)
	@Column(name = "viewing_restriction", nullable = false, length = 10)
	private ViewingRestriction viewingRestriction;

	private Set<Genre> genres = new HashSet<>();
	private Set<Language> audioLanguages = new HashSet<>();
	private Set<Language> subtitleLanguages = new HashSet<>();
	private Set<Content> recommendations = new HashSet<>();
	private Set<Rating> ratings = new HashSet<>();
	private Set<CastMember> castMembers = new HashSet<>();
	//SubtitleContent
}
