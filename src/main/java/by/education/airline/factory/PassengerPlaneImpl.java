package by.education.airline.factory;

import by.education.airline.entity.plane.AbstractPlane;
import by.education.airline.entity.plane.PassengerPlane;

public enum PassengerPlaneImpl implements PlaneFactory {

	INSTANCE;

	@Override
	public AbstractPlane createPlane() {
		return new PassengerPlane();
	}

}
