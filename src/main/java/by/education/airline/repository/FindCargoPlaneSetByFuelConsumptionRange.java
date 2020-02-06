package by.education.airline.repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import by.education.airline.entity.plane.CargoPlane;
import by.education.airline.specification.Specification;

public class FindCargoPlaneSetByFuelConsumptionRange implements Specification<CargoPlane> {

	private double minFuelConsumption;
	private double maxFuelConsumption;

	public FindCargoPlaneSetByFuelConsumptionRange(double minFuelConsumption, double maxFuelConsumption) {
		this.minFuelConsumption = minFuelConsumption;
		this.maxFuelConsumption = maxFuelConsumption;
	}

	@Override
	public Set<CargoPlane> execute() {

		Set<CargoPlane> result = new HashSet<>();

		for (Optional<CargoPlane> plane : CargoPlaneRepositoryImpl.INSTANCE.cargoPlaneList) {

			if (plane.isPresent() && plane.get().getFuelConsumption() >= minFuelConsumption
					&& plane.get().getFuelConsumption() <= maxFuelConsumption) {
				result.add(plane.get());
			}
		}
		return result;
	}

}
