package by.education.airline.criterion.passengerplane;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import by.education.airline.entity.plane.PassengerPlane;
import by.education.airline.repository.PassengerPlaneRepositoryImpl;

public class FindPassengerPlanesByCapacity implements PassengerPlaneCriterion {

	private int capacity;

	public FindPassengerPlanesByCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public Set<PassengerPlane> execute() {

		Set<PassengerPlane> result = new HashSet<>();

		for (Optional<PassengerPlane> plane : PassengerPlaneRepositoryImpl.INSTANCE.getAllPassengerPlanes()) {
			if (plane.isPresent() && plane.get().getCapacity() == capacity) {
				result.add(plane.get());
			}
		}
		return result;
	}
}
