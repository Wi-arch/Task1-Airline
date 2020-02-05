package by.education.airline.repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import by.education.airline.entity.plane.PassengerPlane;
import by.education.airline.specification.Specification;

public class GetPassengerPlaneSet implements Specification<PassengerPlane> {

	@Override
	public Set<PassengerPlane> execute() {
		Set<PassengerPlane> result = new HashSet<>();
		for (Optional<PassengerPlane> plane : PassengerPlaneRepositoryImpl.INSTANCE.passengerPlaneList) {
			if (plane.isPresent()) {
				result.add(plane.get());
			}
		}
		return result;
	}

}
