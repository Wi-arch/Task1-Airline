package by.education.airline.entity.plane;

public enum CargoPlaneModel implements PlaneModel {

	AIRBUS319("Airbus 319"), AIRBUS300("Airbus 300-600 ST"), BOEING747("Boeing 747-400");

	private CargoPlaneModel(String model) {
		this.model = model;
	}

	private String model;

	@Override
	public String getModel() {
		return model;
	}
}
