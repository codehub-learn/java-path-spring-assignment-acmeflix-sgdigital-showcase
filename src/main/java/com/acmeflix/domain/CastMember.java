package com.acmeflix.domain;

import com.acmeflix.domain.enumeration.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "CAST_MEMBERS")
@SequenceGenerator(name = "idGenerator", sequenceName = "CAST_MEMBERS_SEQ", initialValue = 1, allocationSize = 1)
public class CastMember extends BaseModel implements Serializable {
	@ToString.Exclude
	@ManyToOne(optional = false)
	@JoinColumn(name = "person_id")
	private Person person;

	@ToString.Exclude
	@ManyToOne(optional = false)
	@JoinColumn(name = "content_id")
	private Content content;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private Role role;
}
