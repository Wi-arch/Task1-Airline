package by.education.airline.entity.plane;

import java.util.Optional;

import by.education.airline.exception.InvalidPlaneValueException;

public abstract class AbstractPlane {

	protected double fuelConsumption;
	protected PlaneModel model;
	protected Optional<String> airlineName;

	public void setFuelConsumption(double fuelConsumption) throws InvalidPlaneValueException {
		this.fuelConsumption = fuelConsumption;
	}

	public void setModel(PlaneModel model) throws InvalidPlaneValueException {
		this.model = model;
	}

	public double getFuelConsumption() {
		return fuelConsumption;
	}

	public PlaneModel getModel() {
		return model;
	}

	public Optional<String> getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(Optional<String> airline) {
		this.airlineName = airline;
	}

}
