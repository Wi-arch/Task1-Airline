package by.education.airline.validator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import by.education.airline.entity.plane.AbstractPlane;
import by.education.airline.entity.plane.CargoPlane;
import by.education.airline.entity.plane.CargoPlaneModel;
import by.education.airline.entity.plane.PassengerPlane;
import by.education.airline.entity.plane.PassengerPlaneModel;
import by.education.airline.exception.InvalidPlaneValueException;

public class PassengerPlaneValidatorTest {

	private AbstractPlane cargoPlane = new CargoPlane();
	private AbstractPlane passengerPlane = new PassengerPlane();

	@Test
	public void testIsThePlanePassengerPlanePositive() throws InvalidPlaneValueException {
		passengerPlane.setModel(PassengerPlaneModel.BOEING737);
		boolean actual = PassengerPlaneValidator.isThePlanePassengerPlane(passengerPlane);
		assertEquals(true, actual);
	}

	@Test
	public void testIsThePlanePassengerPlaneNegative() throws InvalidPlaneValueException {
		cargoPlane.setModel(CargoPlaneModel.AIRBUS319);
		boolean actual = PassengerPlaneValidator.isThePlanePassengerPlane(cargoPlane);
		assertEquals(false, actual);
	}

	@Test
	public void testIsModelPassengerPlanePositive() {
		boolean actual = PassengerPlaneValidator.isModelPassengerPlane(PassengerPlaneModel.BOEING777);
		assertEquals(true, actual);
	}

	@Test
	public void testIsModelPassengerPlaneNegative() {
		boolean actual = PassengerPlaneValidator.isModelPassengerPlane(CargoPlaneModel.AIRBUS300);
		assertEquals(false, actual);
	}

}
