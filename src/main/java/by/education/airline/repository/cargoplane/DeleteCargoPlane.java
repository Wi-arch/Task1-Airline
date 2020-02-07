package by.education.airline.repository.cargoplane;

import java.util.Optional;
import java.util.Set;

import by.education.airline.entity.plane.CargoPlane;
import by.education.airline.specification.Specification;

public class DeleteCargoPlane implements Specification<CargoPlane> {

	private CargoPlane cargoPlane;

	public DeleteCargoPlane(CargoPlane cargoPlane) {
		this.cargoPlane = cargoPlane;
	}

	@Override
	public Set<CargoPlane> execute() {

		for (Optional<CargoPlane> plane : CargoPlaneRepositoryImpl.INSTANCE.cargoPlaneList) {
			if (plane.isPresent() && plane.get().getId() == cargoPlane.getId()) {
				CargoPlaneRepositoryImpl.INSTANCE.cargoPlaneList.remove(plane);
				break;
			}
		}
		return null;
	}

}
