package by.education.airline.criterion.cargoplane;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import by.education.airline.entity.plane.CargoPlane;
import by.education.airline.repository.CargoPlaneRepositoryImpl;

public class FindCargoPlanesByFuelConsumptionRange implements CargoPlaneCriterion {

	private double minFuelConsumption;
	private double maxFuelConsumption;

	public FindCargoPlanesByFuelConsumptionRange(double minFuelConsumption, double maxFuelConsumption) {
		this.minFuelConsumption = minFuelConsumption;
		this.maxFuelConsumption = maxFuelConsumption;
	}

	@Override
	public Set<CargoPlane> execute() {

		Set<CargoPlane> result = new HashSet<>();

		for (Optional<CargoPlane> plane : CargoPlaneRepositoryImpl.INSTANCE.getAllCargoPlanes()) {

			if (plane.isPresent() && plane.get().getFuelConsumption() >= minFuelConsumption
					&& plane.get().getFuelConsumption() <= maxFuelConsumption) {
				result.add(plane.get());
			}
		}
		return result;
	}

}
