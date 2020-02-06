package by.education.airline.repository.passengerplane;

import java.util.Optional;
import java.util.Set;

import by.education.airline.entity.plane.PassengerPlane;
import by.education.airline.specification.Specification;

public class AddPassengerPlane implements Specification<PassengerPlane> {

	private PassengerPlane passengerPlane;

	public AddPassengerPlane(PassengerPlane passengerPlane) {
		this.passengerPlane = passengerPlane;
	}

	@Override
	public Set<PassengerPlane> execute() {
		PassengerPlaneRepositoryImpl.INSTANCE.passengerPlaneList.add(Optional.ofNullable(passengerPlane));
		return null;
	}

}
