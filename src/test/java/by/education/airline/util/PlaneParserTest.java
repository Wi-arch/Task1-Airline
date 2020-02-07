package by.education.airline.util;

import static org.junit.Assert.assertTrue;

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
	public void init() {

		PassengerPlane plane = new PassengerPlane();
		plane.setAirlineName("GoAir");
		plane.setCapacity(500);
		plane.setFuelConsumption(180.7);
		plane.setModel(PassengerPlaneModel.AIRBUS310);
		plane.setId(1);
		expectedPassengerPlane.add(Optional.ofNullable(plane));

		CargoPlane cargoPlane = new CargoPlane();
		cargoPlane.setAirlineName("Air Costa");
		cargoPlane.setCarryingCapacity(1960);
		cargoPlane.setFuelConsumption(188);
		cargoPlane.setModel(CargoPlaneModel.BOEING747);
		cargoPlane.setId(1);
		expectedCargoPlane.add(Optional.ofNullable(cargoPlane));

	}

	@Test
	public void testParseStringToPassengerPlaneListNegative() {
		actualPassengerPlane = PlaneParser.parseStringToPassengerPlaneList(PASSENGER_PLANE_STRING);
		assertTrue(!actualPassengerPlane.equals(expectedPassengerPlane));
	}

	@Test
	public void testParseStringToPassengerPlaneListPositive() {

		actualPassengerPlane = PlaneParser.parseStringToPassengerPlaneList(PASSENGER_PLANE_STRING);
		actualPassengerPlane.get(0).get().setId(1);
		assertTrue(actualPassengerPlane.equals(expectedPassengerPlane));
	}

	@Test
	public void testParseStringToCargoPlaneListNegative() {

		actualCargoPlane = PlaneParser.parseStringToCargoPlaneList(CARGO_PLANE_STRING);
		assertTrue(!actualCargoPlane.equals(expectedCargoPlane));
	}

	@Test
	public void testParseStringToCargoPlaneListPositive() {

		actualCargoPlane = PlaneParser.parseStringToCargoPlaneList(CARGO_PLANE_STRING);
		actualCargoPlane.get(0).get().setId(1);
		assertTrue(actualCargoPlane.equals(expectedCargoPlane));
	}

}
