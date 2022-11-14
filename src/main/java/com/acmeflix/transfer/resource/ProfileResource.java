package com.acmeflix.transfer.resource;

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
public class ProfileResource extends BaseModelResource {
	private String name;
	private Language language;
	private ViewingRestriction viewingRestriction;
	private Set<ContentRatingResource> ratings = new HashSet<>();
}
