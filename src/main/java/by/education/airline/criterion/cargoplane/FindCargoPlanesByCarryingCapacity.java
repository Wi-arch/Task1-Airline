package by.education.airline.criterion.cargoplane;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import by.education.airline.entity.plane.CargoPlane;
import by.education.airline.repository.CargoPlaneRepositoryImpl;

public class FindCargoPlanesByCarryingCapacity implements CargoPlaneCriterion {

	private double carryingCapacity;

	public FindCargoPlanesByCarryingCapacity(double carryingCapacity) {
		this.carryingCapacity = carryingCapacity;
	}

	@Override
	public Set<CargoPlane> execute() {

		Set<CargoPlane> result = new HashSet<>();

		for (Optional<CargoPlane> plane : CargoPlaneRepositoryImpl.INSTANCE.getAllCargoPlanes()) {

			if (plane.isPresent() && plane.get().getCarryingCapacity() == carryingCapacity) {
				result.add(plane.get());
			}
		}
		return result;
	}
}
