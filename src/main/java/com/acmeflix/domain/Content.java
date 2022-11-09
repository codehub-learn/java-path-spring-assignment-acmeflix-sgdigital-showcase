package com.acmeflix.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
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

	@Builder.Default
	@Enumerated(EnumType.STRING)
	@Column(name = "genre", nullable = false, length = 15)
	@ElementCollection(targetClass = Genre.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "CONTENT_GENRES", indexes = {@Index(columnList = "content_id")}, joinColumns = @JoinColumn(name = "content_id", referencedColumnName = "id"))
	private Set<Genre> genres = new HashSet<>();

	@Builder.Default
	@Enumerated(EnumType.STRING)
	@Column(name = "language", nullable = false, length = 15)
	@ElementCollection(targetClass = Language.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "CONTENT_AUDIO_LANGUAGES", indexes = {@Index(columnList = "content_id")}, joinColumns = @JoinColumn(name = "content_id", referencedColumnName = "id"))
	private Set<Language> audioLanguages = new HashSet<>();

	@Builder.Default
	@Enumerated(EnumType.STRING)
	@Column(name = "language", nullable = false, length = 15)
	@ElementCollection(targetClass = Language.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "CONTENT_SUBTITLE_LANGUAGES", indexes = {@Index(columnList = "content_id")}, joinColumns = @JoinColumn(name = "content_id", referencedColumnName = "id"))
	private Set<Language> subtitleLanguages = new HashSet<>();

	//@formatter:off
	@Builder.Default
	@JoinTable(
			name = "CONTENT_RECOMMENDATIONS",
			indexes = {@Index(columnList = "content_id")},
			joinColumns =  {
					@JoinColumn(
							name = "content_id",
							referencedColumnName = "id",
							nullable = false
					)
			},
			inverseJoinColumns = {
					@JoinColumn(
							name = "recommendation_id",
							referencedColumnName = "id",
							nullable = false
					)
			}
	)
	//@formatter:on
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Content> recommendations = new HashSet<>();

	@Builder.Default
	@OneToMany(mappedBy = "content")
	private Set<Rating> ratings = new HashSet<>();

	@Builder.Default
	@OneToMany(mappedBy = "content")
	private Set<CastMember> castMembers = new HashSet<>();

	//SubtitleContent
}
