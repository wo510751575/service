package com.lj.business.cf.dto.clientKeep;

import java.io.Serializable;

/**
 * The Class UpdateClientKeepReturn.
 */
public class UpdateClientKeepReturn implements Serializable {
	
	/** The code. */
	private String code;
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6400361304957420433L;
	
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
		return "UpdateClientKeepReturn [code=" + code + ", getCode()="
				+ getCode() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	} 

}
