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
public class Season extends BaseModel {
	private String title;
	private Integer ordering;
	private Integer releaseYear;
	private Set<Episode> episodes = new HashSet<>();
}
