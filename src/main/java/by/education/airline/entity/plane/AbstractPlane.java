package by.education.airline.entity.plane;

import by.education.airline.exception.InvalidPlaneValueException;

public abstract class AbstractPlane {

	protected double fuelConsumption;
	protected PlaneModel model;

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

}
