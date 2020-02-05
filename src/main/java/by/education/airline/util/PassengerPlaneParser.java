package by.education.airline.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import by.education.airline.entity.plane.CargoPlaneModel;
import by.education.airline.entity.plane.PassengerPlane;
import by.education.airline.exception.InvalidPlaneValueException;

public class PassengerPlaneParser {

	private final static String CARGO_PLANE_REGEX = "FuelConsumption=\\d+[.,]\\d{0,}\\s+PlaneModel=\\w+\\s+"
			+ "PassengerCapacity=\\d+[.,]\\d{0,}\\s{0,}";
	private final static String FUEL_CONSUMPTION_REGEX = "FuelConsumption=(\\d+)\\s+.*";
	private final static String PLANE_MODEL_REGEX = ".*PlaneModel=(\\w+)\\s+.*";
	private final static String PASSENGER_CAPACITY_REGEX = ".*PassengerCapacity=(\\d+)";

	public static List<Optional<PassengerPlane>> parseStringToPassengerPlanes(String source) {

		List<Optional<PassengerPlane>> result = new LinkedList<>();

		@SuppressWarnings("resource")
		Scanner parser = new Scanner(source);

		while (parser.hasNextLine()) {
			String planeString = parser.nextLine();
			if (planeString.matches(CARGO_PLANE_REGEX)) {
				try {
					PassengerPlane plane = new PassengerPlane();
					double fuelConsumption = Double.valueOf(planeString.replaceAll(FUEL_CONSUMPTION_REGEX, "$1"));
					plane.setFuelConsumption(fuelConsumption);
					CargoPlaneModel model = CargoPlaneModel.valueOf(planeString.replaceAll(PLANE_MODEL_REGEX, "$1"));
					plane.setModel(model);
					int capacity = Integer.valueOf(planeString.replaceAll(PASSENGER_CAPACITY_REGEX, "$1"));
					plane.setCapacity(capacity);
					result.add(Optional.ofNullable(plane));
				} catch (RuntimeException | InvalidPlaneValueException e) {
					// TODO write log
				}

			}
		}
		return result;
	}
}
