package by.education.airline.entity.plane;

public class PassengerPlane extends AbstractPlane {

	private static int idCounter;

	private int passengerCapacity;

	public PassengerPlane() {
		this.id = ++idCounter;
	}

	public int getCapacity() {
		return passengerCapacity;
	}

	public void setCapacity(int capacity) {
		this.passengerCapacity = capacity;
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
