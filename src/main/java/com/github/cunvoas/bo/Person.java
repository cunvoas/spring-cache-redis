package com.github.cunvoas.bo;

import java.io.Serializable;

public class Person implements Serializable {
	/**serialVersionUID */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	/**
	 * Getter for id.
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Setter for id.
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * Getter for firstname.
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * Setter for firstname.
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * Getter for lastname.
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * Setter for lastname.
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * Getter for email.
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Setter for email.
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Getter for phone.
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * Setter for phone.
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
	
}
