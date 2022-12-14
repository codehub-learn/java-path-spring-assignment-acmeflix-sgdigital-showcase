package com.acmeflix.domain;

import com.acmeflix.domain.composite.RatingKey;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "RATINGS")
public class Rating implements Serializable {
	@EmbeddedId
	private RatingKey id = new RatingKey();

	@ToString.Exclude
	@ManyToOne(optional = false)
	@MapsId("profileId")
	@JoinColumn(name = "profile_id")
	private Profile profile;

	@ToString.Exclude
	@ManyToOne(optional = false)
	@MapsId("contentId")
	@JoinColumn(name = "content_id")
	private Content content;

	@Column(nullable = false, precision = 4, scale = 1)
	private Double rate;
}
