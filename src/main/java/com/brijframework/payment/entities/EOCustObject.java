package com.brijframework.payment.entities;

import static com.brijframework.payment.contants.Constants.ACTIVE;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EOCustObject extends EOEntityObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = ACTIVE)
	private Boolean active;

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
