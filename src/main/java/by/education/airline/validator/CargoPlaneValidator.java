package by.education.airline.validator;

import by.education.airline.entity.plane.AbstractPlane;
import by.education.airline.entity.plane.CargoPlaneModel;
import by.education.airline.entity.plane.PlaneModel;

public class CargoPlaneValidator {

	public static boolean isThePlaneCargoPlane(AbstractPlane plane) {
		if (plane != null && isModelCargoPlane(plane.getModel())) {
			return true;
		}
		return false;
	}

	public static boolean isModelCargoPlane(PlaneModel model) {
		return model instanceof CargoPlaneModel;
	}
}
