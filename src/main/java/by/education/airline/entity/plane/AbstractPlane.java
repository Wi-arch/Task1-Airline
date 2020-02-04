package by.education.airline.entity.plane;

import by.education.airline.exception.InvalidPlaneValueException;

public abstract class AbstractPlane {

	protected double fuelConsumption;
	protected PlaneModel model;

	abstract public void setFuelConsumption(double fuelConsumption) throws InvalidPlaneValueException;

	abstract public void setModel(PlaneModel model) throws InvalidPlaneValueException;

	public double getFuelConsumption() {
		return fuelConsumption;
	}

	public PlaneModel getModel() {
		return model;
	}

}
