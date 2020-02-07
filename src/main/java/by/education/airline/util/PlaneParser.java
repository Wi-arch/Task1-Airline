package by.education.airline.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.apache.log4j.Logger;

import by.education.airline.entity.plane.CargoPlane;
import by.education.airline.entity.plane.CargoPlaneModel;
import by.education.airline.entity.plane.PassengerPlane;
import by.education.airline.entity.plane.PassengerPlaneModel;
import by.education.airline.exception.InvalidPlaneValueException;
import by.education.airline.factory.PlaneFactory;

public class PlaneParser {

	private final static Logger LOGGER = Logger.getLogger(PlaneParser.class);
	private final static String CARGO_PLANE_REGEX = "FuelConsumption=\\d+[.]\\d{0,}\\s+PlaneModel=\\w+\\s+"
			+ "CarryingCapacity=\\d+[.]\\d{0,}\\s+AirlineName=.*";
	private final static String PASSENGER_PLANE_REGEX = "FuelConsumption=\\d+[.]\\d{0,}\\s+PlaneModel=\\w+\\s+"
			+ "PassengerCapacity=\\d+([.]\\d{0,})?\\s+AirlineName=.*";
	private final static String FUEL_CONSUMPTION_REGEX = "FuelConsumption=(\\d+[.]\\d{0,})\\s+.*";
	private final static String PLANE_MODEL_REGEX = ".*PlaneModel=(\\w+)\\s+.*";
	private final static String PASSENGER_CAPACITY_REGEX = ".*PassengerCapacity=(\\d+)\\s+.*";
	private final static String AIRLINE_NAME_REGEX = ".*AirlineName=(.*)";
	private final static String CARRYING_CAPACITY_REGEX = ".*CarryingCapacity=(\\d+[.]\\d{0,})\\s+.*";
	private static Scanner scanner;

	public static List<Optional<PassengerPlane>> parseStringToPassengerPlaneList(String source) {

		List<Optional<PassengerPlane>> result = new LinkedList<>();
		scanner = new Scanner(source);
		String planeString = null;
		PassengerPlane plane = null;
		while (scanner.hasNextLine()) {
			planeString = scanner.nextLine();
			if (planeString.matches(PASSENGER_PLANE_REGEX)) {
				try {
					double fuelConsumption = Double.valueOf(planeString.replaceAll(FUEL_CONSUMPTION_REGEX, "$1"));
					PassengerPlaneModel model = PassengerPlaneModel
							.valueOf(planeString.replaceAll(PLANE_MODEL_REGEX, "$1").toUpperCase());
					int capacity = Integer.valueOf(planeString.replaceAll(PASSENGER_CAPACITY_REGEX, "$1"));
					String airline = planeString.replaceAll(AIRLINE_NAME_REGEX, "$1");
					plane = (PassengerPlane) PlaneFactory.INSTANCE.createPlane(model, fuelConsumption, airline);
					plane.setCapacity(capacity);
					result.add(Optional.ofNullable(plane));
				} catch (RuntimeException | InvalidPlaneValueException e) {
					LOGGER.warn("Cannot parse invalid value ", e);
				}
			}
		}
		return result;
	}

	public static List<Optional<CargoPlane>> parseStringToCargoPlaneList(String source) {

		List<Optional<CargoPlane>> result = new LinkedList<>();
		scanner = new Scanner(source);
		String planeString = null;
		CargoPlane cargoPlane = null;
		while (scanner.hasNextLine()) {
			planeString = scanner.nextLine();
			if (planeString.matches(CARGO_PLANE_REGEX)) {
				try {
					double fuelConsumption = Double.valueOf(planeString.replaceAll(FUEL_CONSUMPTION_REGEX, "$1"));
					CargoPlaneModel model = CargoPlaneModel
							.valueOf(planeString.replaceAll(PLANE_MODEL_REGEX, "$1").toUpperCase());
					double carryingCapacity = Double.valueOf(planeString.replaceAll(CARRYING_CAPACITY_REGEX, "$1"));
					String airline = planeString.replaceAll(AIRLINE_NAME_REGEX, "$1");
					cargoPlane = (CargoPlane) PlaneFactory.INSTANCE.createPlane(model, fuelConsumption, airline);
					cargoPlane.setCarryingCapacity(carryingCapacity);
					result.add(Optional.ofNullable(cargoPlane));
				} catch (RuntimeException | InvalidPlaneValueException e) {
					LOGGER.warn("Cannot parse invalid value ", e);
				}
			}
		}
		return result;
	}
}
