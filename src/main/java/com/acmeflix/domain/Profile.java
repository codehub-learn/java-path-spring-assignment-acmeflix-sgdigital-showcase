package com.acmeflix.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "PROFILES")
@SequenceGenerator(name = "idGenerator", sequenceName = "PROFILES_SEQ", initialValue = 1, allocationSize = 1)
public class Profile extends BaseModel {
	@Column(nullable = false, unique = true, length = 20)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private Language language;

	@Enumerated(EnumType.STRING)
	@Column(name = "viewing_restriction", nullable = false, length = 10)
	private ViewingRestriction viewingRestriction;

	@Builder.Default
	@OneToMany(mappedBy = "profile")
	private Set<Rating> ratings = new HashSet<>();

	@ToString.Exclude
	@ManyToOne(optional = false)
	private Account account;

	//Activity
}
