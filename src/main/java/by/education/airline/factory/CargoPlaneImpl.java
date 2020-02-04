package by.education.airline.factory;

import by.education.airline.entity.plane.AbstractPlane;
import by.education.airline.entity.plane.CargoPlane;

public enum CargoPlaneImpl implements PlaneFactory {

	INSTANCE;

	@Override
	public AbstractPlane createPlane() {
		return new CargoPlane();
	}

}
