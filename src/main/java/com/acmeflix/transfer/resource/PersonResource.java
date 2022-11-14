package com.acmeflix.transfer.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
public class PersonResource extends BaseModelResource {
	private String firstName;
	private String lastName;
	private Set<CastMemberResource> castMembers = new HashSet<>();
}
