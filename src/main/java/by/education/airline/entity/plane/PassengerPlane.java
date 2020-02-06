package by.education.airline.entity.plane;

import org.apache.log4j.Logger;

import by.education.airline.exception.InvalidPlaneValueException;
import by.education.airline.validator.PassengerPlaneValidator;

public class PassengerPlane extends AbstractPlane {

	private static int idCounter;
	private static final Logger LOGGER = Logger.getLogger(PassengerPlane.class);

	private int passengerCapacity;
	private int id;

	public PassengerPlane() {
		this.id = ++idCounter;
	}

	public int getId() {
		return id;
	}

	public int getCapacity() {
		return passengerCapacity;
	}

	public void setCapacity(int capacity) throws InvalidPlaneValueException {
		if (capacity <= 0) {
			LOGGER.warn("Invalid passenger capacity");
			throw new InvalidPlaneValueException("Invalid passenger capacity");
		}
		this.passengerCapacity = capacity;
	}

	public void setFuelConsumption(double fuelConsumption) throws InvalidPlaneValueException {
		if (fuelConsumption < 0) {
			LOGGER.warn("Invalid fuel consumption");
			throw new InvalidPlaneValueException("Fuel consumption cannot be negativ");
		}
		this.fuelConsumption = fuelConsumption;
	}

	public void setModel(PlaneModel model) throws InvalidPlaneValueException {
		if (!PassengerPlaneValidator.isModelPassengerPlane(model)) {
			LOGGER.warn("Invalid model type");
			throw new InvalidPlaneValueException("Invalid passenger plane model");
		}
		this.model = model;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		result = prime * result + id;
		temp = Double.doubleToLongBits(fuelConsumption);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + passengerCapacity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PassengerPlane other = (PassengerPlane) obj;
		if (id != other.id)
			return false;
		if (passengerCapacity != other.passengerCapacity)
			return false;
		if (Double.doubleToLongBits(fuelConsumption) != Double.doubleToLongBits(other.fuelConsumption))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PassengerPlane [fuelConsumption=" + fuelConsumption + ", model=" + model + ", passengerCapacity="
				+ passengerCapacity + "]";
	}

}
