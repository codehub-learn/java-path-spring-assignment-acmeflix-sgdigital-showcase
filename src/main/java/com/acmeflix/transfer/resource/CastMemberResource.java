package com.acmeflix.transfer.resource;

import com.acmeflix.domain.enumeration.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class CastMemberResource extends BaseModelResource {
	private String personName;
	private String contentTitle;
	private Role role;

}
