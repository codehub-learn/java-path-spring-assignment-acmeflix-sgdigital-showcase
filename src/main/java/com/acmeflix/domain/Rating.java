package com.acmeflix.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class Rating extends BaseModel {
	private Profile profile;
	private Content content;
	private Double rate;
}
