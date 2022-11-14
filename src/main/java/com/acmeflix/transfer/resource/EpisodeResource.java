package com.acmeflix.transfer.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class EpisodeResource extends BaseModelResource {
	private String title;
	private String summary;
	private Integer durationInMinutes;
}
