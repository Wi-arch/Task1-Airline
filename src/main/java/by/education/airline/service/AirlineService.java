package by.education.airline.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

import by.education.airline.entity.airline.Airline;
import by.education.airline.entity.plane.AbstractPlane;
import by.education.airline.entity.plane.CargoPlane;
import by.education.airline.entity.plane.PassengerPlane;
import by.education.airline.exception.ServiceException;
import by.education.airline.validator.CargoPlaneValidator;
import by.education.airline.validator.PassengerPlaneValidator;

public class AirlineService {

	private AirlineService() {
	}

	private static class AirlineServiceInstance {
		private final static AirlineService INSTANCE = new AirlineService();
	}

	public static AirlineService getInstance() {
		return AirlineServiceInstance.INSTANCE;
	}

	public double getTotalCarryingCapacity(Airline airline) throws ServiceException {

		if (airline == null) {
			throw new ServiceException("Null airline");
		}
		double totalCapacity = 0;
		for (AbstractPlane plane : airline.getAllPlanes()) {
			if (CargoPlaneValidator.isThePlaneCargoPlane(plane)) {
				CargoPlane temp = (CargoPlane) plane;
				totalCapacity += temp.getCarryingCapacity();
			}
		}
		return totalCapacity;
	}

	public int getTotalPassengersCapacity(Airline airline) throws ServiceException {

		if (airline == null) {
			throw new ServiceException("Null airline");
		}
		int totalCapacity = 0;

		for (AbstractPlane plane : airline.getAllPlanes()) {
			if (PassengerPlaneValidator.isThePlanePassengerPlane(plane)) {
				PassengerPlane temp = (PassengerPlane) plane;
				totalCapacity += temp.getCapacity();
			}
		}
		return totalCapacity;
	}

	public void sortPlanes(Airline airline, Comparator<? super AbstractPlane> c) throws ServiceException {
		if (airline == null) {
			throw new ServiceException("Null airline");
		}
		Collections.sort(airline.getAllPlanes().stream().collect(Collectors.toList()), c);
	}
}
