package com.acmeflix.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ViewingRestriction {
	SEVEN(7), THIRTEEN(13), SIXTEEN(16), EIGHTEEN(18), ALL(1000);
	private final Integer age;
}
