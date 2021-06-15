package com.hari.dsal.mislanious;

public class HashCodeAndEquals {

	int code;
	public String name;
	public int id;

	HashCodeAndEquals(String name, int id) {

		this.name = name;
		this.id = id;
	}

	public boolean equals(Object obj) {
		// checking if both the object references are
		// referring to the same object.
		if (this == obj)
			return true;

		if (obj == null || obj.getClass() != this.getClass())
			return false;

		Greek g = (Greek) obj;

		// comparing the state of argument with
		// the state of 'this' Object.
		return (g.name == this.name && g.id == this.id);
	}

	public int hashCode() {
		return code;
	}
}
