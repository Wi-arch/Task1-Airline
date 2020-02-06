package by.education.airline.entity.airline;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import by.education.airline.entity.plane.AbstractPlane;

public class Airline {

	private Optional<String> name;
	private List<AbstractPlane> planeList;

	public Airline() {
		this.name = Optional.empty();
		this.planeList = new LinkedList<>();
	}

	public Airline(String name) {
		this.name = Optional.ofNullable(name);
		this.planeList = new LinkedList<>();
	}

	public Optional<String> getName() {
		return name;
	}

	public void setName(String name) {
		this.name = Optional.ofNullable(name);
	}

	public boolean addPlane(AbstractPlane plane) {
		return plane == null ? false : planeList.add(plane);
	}

	public List<AbstractPlane> getAllPlanes() {
		return this.planeList;
	}

	public int getNumberOfPlanes() {
		return this.planeList.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((planeList == null) ? 0 : planeList.hashCode());
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
		if (planeList == null) {
			if (other.planeList != null)
				return false;
		} else if (!planeList.equals(other.planeList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Airline [name=" + name + ", planes=" + planeList + "]";
	}

}
