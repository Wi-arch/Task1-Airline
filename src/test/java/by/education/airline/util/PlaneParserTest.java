package by.education.airline.util;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import by.education.airline.entity.plane.CargoPlane;
import by.education.airline.entity.plane.CargoPlaneModel;
import by.education.airline.entity.plane.PassengerPlane;
import by.education.airline.entity.plane.PassengerPlaneModel;

public class PlaneParserTest {

	private final static String PASSENGER_PLANE_STRING = "FuelConsumption=180.7 PlaneModel=AIRBUS310 PassengerCapacity=500"
			+ " AirlineName=GoAir";
	private final static String CARGO_PLANE_STRING = "FuelConsumption=188.0 PlaneModel=BOEING747 CarryingCapacity=1960.0 "
			+ "AirlineName=Air Costa";
	private List<Optional<PassengerPlane>> expectedPassengerPlane = new LinkedList<>();
	private List<Optional<CargoPlane>> expectedCargoPlane = new LinkedList<>();
	private List<Optional<PassengerPlane>> actualPassengerPlane = new LinkedList<>();
	private List<Optional<CargoPlane>> actualCargoPlane = new LinkedList<>();

	@Before
	public void init() throws Exception {

		PassengerPlane plane = new PassengerPlane();
		plane.setAirlineName("GoAir");
		plane.setCapacity(500);
		plane.setFuelConsumption(180.7);
		plane.setModel(PassengerPlaneModel.AIRBUS310);
		expectedPassengerPlane.add(Optional.ofNullable(plane));
		setSameIDToPassengerPlane(expectedPassengerPlane);

		CargoPlane cargoPlane = new CargoPlane();
		cargoPlane.setAirlineName("Air Costa");
		cargoPlane.setCarryingCapacity(1960);
		cargoPlane.setFuelConsumption(188);
		cargoPlane.setModel(CargoPlaneModel.BOEING747);
		expectedCargoPlane.add(Optional.ofNullable(cargoPlane));
		setSameIDToCargoPlane(expectedCargoPlane);

	}

	@Test
	public void testParseStringToPassengerPlaneListNegative() {
		actualPassengerPlane = PlaneParser.parseStringToPassengerPlaneList(PASSENGER_PLANE_STRING);
		assertTrue(!actualPassengerPlane.equals(expectedPassengerPlane));
	}

	@Test
	public void testParseStringToPassengerPlaneListPositive() throws Exception {

		actualPassengerPlane = PlaneParser.parseStringToPassengerPlaneList(PASSENGER_PLANE_STRING);
		setSameIDToPassengerPlane(actualPassengerPlane);
		assertTrue(actualPassengerPlane.equals(expectedPassengerPlane));
	}

	@Test
	public void testParseStringToCargoPlaneListNegative() throws Exception {

		actualCargoPlane = PlaneParser.parseStringToCargoPlaneList(CARGO_PLANE_STRING);

		assertTrue(!actualCargoPlane.equals(expectedCargoPlane));
	}

	@Test
	public void testParseStringToCargoPlaneListPositive() throws Exception {

		actualCargoPlane = PlaneParser.parseStringToCargoPlaneList(CARGO_PLANE_STRING);
		setSameIDToCargoPlane(actualCargoPlane);
		assertTrue(actualCargoPlane.equals(expectedCargoPlane));
	}

	private void setSameIDToPassengerPlane(List<Optional<PassengerPlane>> target) throws Exception {

		PassengerPlane tempPlane = null;
		Field idField = null;
		for (Optional<PassengerPlane> plane : target) {
			tempPlane = plane.get();
			idField = tempPlane.getClass().getDeclaredField("id");
			idField.setAccessible(true);
			idField.setInt(tempPlane, 1);
			idField.setAccessible(false);
		}
	}

	private void setSameIDToCargoPlane(List<Optional<CargoPlane>> target) throws Exception {

		CargoPlane tempPlane = null;
		Field idField = null;
		for (Optional<CargoPlane> plane : target) {
			tempPlane = plane.get();
			idField = tempPlane.getClass().getDeclaredField("id");
			idField.setAccessible(true);
			idField.setInt(tempPlane, 1);
			idField.setAccessible(false);
		}
	}

}
