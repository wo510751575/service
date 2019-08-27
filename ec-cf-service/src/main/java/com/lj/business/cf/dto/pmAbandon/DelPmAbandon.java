package com.lj.business.cf.dto.pmAbandon;

import java.io.Serializable;

/**
 * The Class DelPmAbandon.
 */
public class DelPmAbandon implements Serializable {
	
	/** The code. */
	private String code;
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5168725300723728708L;
	
	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Sets the code.
	 *
	 * @param code the code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DelPmAbandon [code=" + code + ", getCode()=" + getCode()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
