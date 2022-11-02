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
public class Profile extends BaseModel {
	private String name;
	private Language language;
	private ViewingRestriction viewingRestriction;
	private Set<Rating> ratings = new HashSet<>();
	//Activity
}
