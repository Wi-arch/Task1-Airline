package by.education.airline.repository.cargoplane;

import java.util.Optional;
import java.util.Set;

import by.education.airline.entity.plane.CargoPlane;
import by.education.airline.specification.Specification;

public class AddCargoPlane implements Specification<CargoPlane> {

	private CargoPlane cargoPlane;

	public AddCargoPlane(CargoPlane cargoPlane) {
		this.cargoPlane = cargoPlane;
	}

	@Override
	public Set<CargoPlane> execute() {
		CargoPlaneRepositoryImpl.INSTANCE.cargoPlaneList.add(Optional.ofNullable(cargoPlane));
		return null;
	}

}
