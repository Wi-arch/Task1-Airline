package by.education.airline.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import by.education.airline.entity.plane.CargoPlane;
import by.education.airline.entity.plane.CargoPlaneModel;
import by.education.airline.exception.InvalidPlaneValueException;

public class CargoPlaneParser {

	private final static String CARGO_PLANE_REGEX = "FuelConsumption=\\d+[.,]\\d{0,}\\s+PlaneModel=\\w+\\s+"
			+ "CarryingCapacity=\\d+[.,]\\d{0,}\\s{0,}";
	private final static String FUEL_CONSUMPTION_REGEX = "FuelConsumption=(\\d+)\\s+.*";
	private final static String PLANE_MODEL_REGEX = ".*PlaneModel=(\\w+)\\s+.*";
	private final static String CARRYING_CAPACITY_REGEX = ".*CarryingCapacity=(\\d+)";

	public static List<Optional<CargoPlane>> parseStringToCargoPlanes(String source) {

		List<Optional<CargoPlane>> result = new LinkedList<>();

		@SuppressWarnings("resource")
		Scanner parser = new Scanner(source);

		while (parser.hasNextLine()) {
			String planeString = parser.nextLine();
			if (planeString.matches(CARGO_PLANE_REGEX)) {
				try {
					CargoPlane plane = new CargoPlane();
					double fuelConsumption = Double.valueOf(planeString.replaceAll(FUEL_CONSUMPTION_REGEX, "$1"));
					plane.setFuelConsumption(fuelConsumption);
					CargoPlaneModel model = CargoPlaneModel.valueOf(planeString.replaceAll(PLANE_MODEL_REGEX, "$1"));
					plane.setModel(model);
					double carryingCapacity = Double.valueOf(planeString.replaceAll(CARRYING_CAPACITY_REGEX, "$1"));
					plane.setCarryingCapacity(carryingCapacity);
					result.add(Optional.ofNullable(plane));
				} catch (RuntimeException | InvalidPlaneValueException e) {
					// TODO write log
				}

			}
		}
		return result;
	}
}
