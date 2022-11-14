package com.acmeflix.transfer.resource;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString(callSuper = true)
public class BaseModelResource implements Serializable {
	protected Long id;
}
