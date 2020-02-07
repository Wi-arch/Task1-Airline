package by.education.airline.factory;

import org.apache.log4j.Logger;

import by.education.airline.entity.plane.AbstractPlane;
import by.education.airline.entity.plane.CargoPlane;
import by.education.airline.entity.plane.CargoPlaneModel;
import by.education.airline.entity.plane.PassengerPlane;
import by.education.airline.entity.plane.PassengerPlaneModel;
import by.education.airline.entity.plane.PlaneModel;
import by.education.airline.exception.InvalidPlaneValueException;
import by.education.airline.validator.AbstractPlaneValidator;

public enum PlaneFactory {

	INSTANCE;
	private final static Logger LOGGER = Logger.getLogger(PlaneFactory.class);

	public AbstractPlane createPlane(PlaneModel planeModel, double fuelConsumption, String airlineName)
			throws InvalidPlaneValueException {
		if (planeModel == null) {
			LOGGER.warn("Cannot create plane, null plane model");
			throw new InvalidPlaneValueException("Null plane model");
		}
		if (!AbstractPlaneValidator.isFuelConsumptionPositive(fuelConsumption)) {
			LOGGER.warn("Cannot create plane, negative fuel consumption");
			throw new InvalidPlaneValueException("Negative fuel consumption");
		}
		if (airlineName == null) {
			LOGGER.warn("Cannot create plane, null airline name");
			throw new InvalidPlaneValueException("Null airline name");
		}
		AbstractPlane abstractPlane = null;
		if (planeModel instanceof PassengerPlaneModel) {
			abstractPlane = new PassengerPlane();
		}
		if (planeModel instanceof CargoPlaneModel) {
			abstractPlane = new CargoPlane();
		}
		abstractPlane.setFuelConsumption(fuelConsumption);
		abstractPlane.setAirlineName(airlineName);

		return abstractPlane;
	}
}
