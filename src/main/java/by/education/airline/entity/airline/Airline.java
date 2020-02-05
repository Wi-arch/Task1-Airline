package by.education.airline.entity.airline;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import by.education.airline.entity.plane.AbstractPlane;

public class Airline {

	private Optional<String> name;
	private Set<Optional<AbstractPlane>> planes;

	public Airline() {
		this.name = Optional.empty();
		this.planes = new HashSet<>();
	}

	public Airline(String name) {
		this.name = Optional.ofNullable(name);
		this.planes = new HashSet<>();
	}

	public Optional<String> getName() {
		return name;
	}

	public void setName(String name) {
		this.name = Optional.ofNullable(name);
	}

	public boolean addPlane(Optional<AbstractPlane> plane) {
		return this.planes.add(plane);
	}

	public boolean addAllPlanes(Optional<Collection<? extends Optional<AbstractPlane>>> c) {
		return this.planes.addAll(c.orElseGet(HashSet::new));
	}

	public Set<Optional<AbstractPlane>> getAllPlanes() {
		return this.planes;
	}

	public int getNumberOfPlanes() {
		return this.planes.size();
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
