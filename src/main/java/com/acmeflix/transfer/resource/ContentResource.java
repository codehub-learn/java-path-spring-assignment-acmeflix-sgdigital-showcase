package com.acmeflix.transfer.resource;

import com.acmeflix.domain.enumeration.Genre;
import com.acmeflix.domain.enumeration.Language;
import com.acmeflix.domain.enumeration.ViewingRestriction;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
public class ContentResource extends BaseModelResource {
	private String title;
	private String plot;
	private Integer releaseYear;
	private ViewingRestriction viewingRestriction;
	private Set<Genre> genres = new HashSet<>();
	private Set<Language> audioLanguages = new HashSet<>();
	private Set<Language> subtitleLanguages = new HashSet<>();
	private Set<ContentResource> recommendations = new HashSet<>();
	private Set<CastMemberResource> castMembers = new HashSet<>();
	private String rate;

}
