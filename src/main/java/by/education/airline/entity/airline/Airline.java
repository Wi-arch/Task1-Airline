package by.education.airline.entity.airline;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import by.education.airline.entity.plane.AbstractPlane;

public class Airline {

	private Optional<String> name;
	private Set<AbstractPlane> planeSet;

	public Airline() {
		this.name = Optional.empty();
		this.planeSet = new HashSet<>();
	}

	public Airline(String name) {
		this.name = Optional.ofNullable(name);
		this.planeSet = new HashSet<>();
	}

	public Optional<String> getName() {
		return name;
	}

	public void setName(String name) {
		this.name = Optional.ofNullable(name);
	}

	public boolean addPlane(AbstractPlane plane) {
		return plane == null ? false : planeSet.add(plane);
	}

	public Set<AbstractPlane> getAllPlanes() {
		return this.planeSet;
	}

	public int getNumberOfPlanes() {
		return this.planeSet.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((planeSet == null) ? 0 : planeSet.hashCode());
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
		if (planeSet == null) {
			if (other.planeSet != null)
				return false;
		} else if (!planeSet.equals(other.planeSet))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Airline [name=" + name + ", planes=" + planeSet + "]";
	}

}
