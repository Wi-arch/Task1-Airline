package by.education.airline.validator;

public class AbstractPlaneValidator {

	public static boolean isFuelConsumptionPositive(double fuelConsumption) {
		return fuelConsumption > 0;
	}
}
