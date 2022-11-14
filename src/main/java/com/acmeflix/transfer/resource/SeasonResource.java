package com.acmeflix.transfer.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
public class SeasonResource extends BaseModelResource {
	private String title;
	private Integer ordering;
	private Integer releaseYear;
	private Set<EpisodeResource> episodes = new HashSet<>();
}
