package com.lrn.sb.restservices.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class User {
	@Id
	@GeneratedValue
	private int id;
	@Size(min=2, message="Name should have atleast 2 characters")
	private String name;
	private String dob;

	public User() {

	}

	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(final String dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";
	}
	public User(final int id, final String name, final String dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + id;
		return result;
	}
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(final int id) {
		this.id = id;
	}

}
