package com.robotanz.flood;

public class Color {
	
	int value;
	
	public Color(int rgba) {
		this.value = rgba;
	}
	
	/*
	 * Eclipse generated methods
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Color other = (Color) obj;
		if (value != other.value)
			return false;
		return true;
	}
}
