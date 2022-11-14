package com.acmeflix.transfer.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class ContentRatingResource implements Serializable {
	private String contentTitle;
	private String rate;
}
