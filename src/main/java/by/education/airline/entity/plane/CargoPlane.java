package by.education.airline.entity.plane;

public class CargoPlane extends AbstractPlane {

	private static int idCounter;

	private double carryingCapacity;

	public CargoPlane() {
		this.id = ++idCounter;
	}

	public double getCarryingCapacity() {
		return carryingCapacity;
	}

	public void setCarryingCapacity(double carryingCapacity) {
		this.carryingCapacity = carryingCapacity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		result = prime * result + id;
		temp = Double.doubleToLongBits(carryingCapacity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(fuelConsumption);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((model == null) ? 0 : model.hashCode());
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
		CargoPlane other = (CargoPlane) obj;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(carryingCapacity) != Double.doubleToLongBits(other.carryingCapacity))
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
		return "CargoPlane [fuelConsumption=" + fuelConsumption + ", model=" + model + ", carryingCapacity="
				+ carryingCapacity + "]";
	}

}
