package com.acmeflix.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class Content extends BaseModel {
	private String title;
	private String plot;
	private Integer releaseYear;
	private ViewingRestriction viewingRestriction;
	private Set<Genre> genres = new HashSet<>();
	private Set<Language> audioLanguage = new HashSet<>();
	private Set<Language> subtitleLanguage = new HashSet<>();
	private Set<Content> recommendations = new HashSet<>();
	private Set<Rating> ratings = new HashSet<>();
	private Set<CastMember> castMembers = new HashSet<>();
	//SubtitleContent
}
