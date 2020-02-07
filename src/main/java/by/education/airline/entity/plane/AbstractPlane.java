package by.education.airline.entity.plane;

import java.util.Optional;

public abstract class AbstractPlane {

	protected double fuelConsumption;
	protected PlaneModel model;
	protected String airlineName;
	protected int id;

	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public void setModel(PlaneModel model) {
		this.model = model;
	}

	public double getFuelConsumption() {
		return fuelConsumption;
	}

	public PlaneModel getModel() {
		return model;
	}

	public Optional<String> getAirlineName() {
		return Optional.ofNullable(airlineName);
	}

	public void setAirlineName(String airline) {
		this.airlineName = airline;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
