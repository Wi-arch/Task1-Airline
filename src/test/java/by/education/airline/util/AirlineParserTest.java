package by.education.airline.util;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import by.education.airline.entity.airline.Airline;

public class AirlineParserTest {

	private final static String SOURCE = "AirlineName=Air Costa";
	private List<Airline> expected;
	private List<Airline> actual;

	@Before
	public void init() {
		expected = new LinkedList<>();
	}

	@Test
	public void testParseStringToAirlineListPositive() {
		actual = AirlineParser.parseStringToAirlineList(SOURCE);
		expected.add(new Airline("Air Costa"));
		assertEquals(expected, actual);
	}

	@Test
	public void testParseStringToAirlineListNegative() {
		actual = AirlineParser.parseStringToAirlineList(null);
		assertEquals(expected, actual);
	}
}
