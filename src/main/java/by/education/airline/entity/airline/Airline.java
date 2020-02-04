package by.education.airline.entity.airline;

import java.util.ArrayList;
import java.util.List;

import by.education.airline.entity.plane.AbstractPlane;
import by.education.airline.exception.InvalidPlaneValueException;

public class Airline {

	private String name;
	private List<AbstractPlane> planes;

	public Airline() {
		this.planes = new ArrayList<>();
	}

	public Airline(String name) {
		this.name = name;
		this.planes = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws InvalidPlaneValueException {
		this.name = name;
	}

	public List<AbstractPlane> getPlanes() {
		return planes;
	}

	public void setPlanes(List<AbstractPlane> planes) {
		this.planes = planes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((planes == null) ? 0 : planes.hashCode());
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
		Airline other = (Airline) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (planes == null) {
			if (other.planes != null)
				return false;
		} else if (!planes.equals(other.planes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Airline [name=" + name + ", planes=" + planes + "]";
	}

}
