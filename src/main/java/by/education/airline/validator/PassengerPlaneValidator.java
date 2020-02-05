package by.education.airline.validator;

import by.education.airline.entity.plane.AbstractPlane;
import by.education.airline.entity.plane.PassengerPlaneModel;
import by.education.airline.entity.plane.PlaneModel;

public class PassengerPlaneValidator {

	public static boolean isThePlanePassengerPlane(AbstractPlane plane) {
		if (plane != null && isModelPassengerPlane(plane.getModel())) {
			return true;
		}
		return false;
	}

	public static boolean isModelPassengerPlane(PlaneModel model) {
		return model instanceof PassengerPlaneModel;
	}
}
