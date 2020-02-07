package by.education.airline.entity.plane;

public enum PassengerPlaneModel implements PlaneModel {

	BOEING737("Boeing 737"), BOEING777("Boeing 777"), AIRBUS310("Airbus 310"), AIRBUS330("Airbus 330");

	private PassengerPlaneModel(String model) {
		this.model = model;
	}

	private String model;

	@Override
	public String getModel() {
		return model;
	}

}
