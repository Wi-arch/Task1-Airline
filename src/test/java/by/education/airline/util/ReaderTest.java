package by.education.airline.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReaderTest {

	private final static String PATH = "PassengerPlanes.txt";
	private final static String EXPECTED = "FuelConsumption=180.9 PlaneModel=AIRBUS330 PassengerCapacity=500 AirlineName=Air Costa\r\n"
			+ "FuelConsumption=185.0 PlaneModel=AIRBUS330 PassengerCapacity=550 AirlineName=GoAir\r\n";
	private final static String WRONG_PATH = "tratata.txt";

	@Test
	public void testReadStringFromFilePositive() {

		Reader reader = Reader.getInstance();
		String actual = reader.readStringFromFile(PATH);
		assertEquals(EXPECTED, actual);
	}

	@Test(expected = RuntimeException.class)
	public void testReadStringFromFileNegative() {

		Reader reader = Reader.getInstance();
		String actual = reader.readStringFromFile(WRONG_PATH);
		assertEquals(EXPECTED, actual);
	}

}
