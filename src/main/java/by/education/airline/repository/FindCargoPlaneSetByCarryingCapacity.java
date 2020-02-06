package by.education.airline.repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import by.education.airline.entity.plane.CargoPlane;
import by.education.airline.specification.Specification;

public class FindCargoPlaneSetByCarryingCapacity implements Specification<CargoPlane> {

	private double carryingCapacity;

	public FindCargoPlaneSetByCarryingCapacity(double carryingCapacity) {
		this.carryingCapacity = carryingCapacity;
	}

	@Override
	public Set<CargoPlane> execute() {

		Set<CargoPlane> result = new HashSet<>();

		for (Optional<CargoPlane> plane : CargoPlaneRepositoryImpl.INSTANCE.cargoPlaneList) {

			if (plane.isPresent() && plane.get().getCarryingCapacity() == carryingCapacity) {
				result.add(plane.get());
			}
		}
		return result;
	}
}
