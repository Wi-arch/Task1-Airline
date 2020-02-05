package by.education.airline.repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import by.education.airline.entity.plane.CargoPlane;
import by.education.airline.specification.Specification;

public class GetCargoPlaneSet implements Specification<CargoPlane> {

	@Override
	public Set<CargoPlane> execute() {
		Set<CargoPlane> result = new HashSet<>();
		for (Optional<CargoPlane> plane : CargoPlaneRepositoryImpl.INSTANCE.cargoPlaneList) {
			if (plane.isPresent()) {
				result.add(plane.get());
			}
		}
		return result;
	}

}
