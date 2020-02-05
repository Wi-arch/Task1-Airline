package by.education.airline.criterion.passengerplane;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import by.education.airline.entity.plane.PassengerPlane;
import by.education.airline.entity.plane.PassengerPlaneModel;
import by.education.airline.repository.PassengerPlaneRepositoryImpl;

public class FindPassengerPlanesByModel implements PassengerPlaneCriterion {

	private PassengerPlaneModel model;

	public FindPassengerPlanesByModel(PassengerPlaneModel model) {
		this.model = model;
	}

	@Override
	public Set<PassengerPlane> execute() {

		Set<PassengerPlane> result = new HashSet<>();

		for (Optional<PassengerPlane> plane : PassengerPlaneRepositoryImpl.INSTANCE.getAllPassengerPlanes()) {
			if (plane.isPresent() && plane.get().getModel() == model) {
				result.add(plane.get());
			}
		}
		return result;
	}
}
