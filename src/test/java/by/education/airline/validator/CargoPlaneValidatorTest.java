package by.education.airline.validator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import by.education.airline.entity.plane.AbstractPlane;
import by.education.airline.entity.plane.CargoPlane;
import by.education.airline.entity.plane.CargoPlaneModel;
import by.education.airline.entity.plane.PassengerPlane;
import by.education.airline.entity.plane.PassengerPlaneModel;
import by.education.airline.exception.InvalidPlaneValueException;

public class CargoPlaneValidatorTest {

	private AbstractPlane cargoPlane = new CargoPlane();
	private AbstractPlane passengerPlane = new PassengerPlane();

	@Test
	public void testIsThePlaneCargoPlanePositive() throws InvalidPlaneValueException {
		cargoPlane.setModel(CargoPlaneModel.AIRBUS319);
		boolean actual = CargoPlaneValidator.isThePlaneCargoPlane(cargoPlane);
		assertEquals(true, actual);
	}

	@Test
	public void testIsThePlaneCargoPlaneNegative() throws InvalidPlaneValueException {
		passengerPlane.setModel(PassengerPlaneModel.BOEING737);
		boolean actual = CargoPlaneValidator.isThePlaneCargoPlane(passengerPlane);
		assertEquals(false, actual);
	}

	@Test
	public void testIsModelCargoModelPositive() {
		boolean actual = CargoPlaneValidator.isModelCargoPlane(CargoPlaneModel.AIRBUS300);
		assertEquals(true, actual);
	}

	@Test
	public void testIsModelCargoModelNegative() {
		boolean actual = CargoPlaneValidator.isModelCargoPlane(PassengerPlaneModel.AIRBUS310);
		assertEquals(false, actual);
	}

}
