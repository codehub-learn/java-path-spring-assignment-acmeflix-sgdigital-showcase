package com.acmeflix.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@ToString
@NoArgsConstructor
public class RatingKey implements Serializable {
	private Long profileId;
	private Long contentId;
}
