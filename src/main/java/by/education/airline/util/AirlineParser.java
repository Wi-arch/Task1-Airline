package by.education.airline.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import by.education.airline.entity.airline.Airline;

public class AirlineParser {

	private final static String AIRLINE_NAME_REGEX = "AirlineName=(.+)";
	private static final Logger LOGGER = Logger.getLogger(AirlineParser.class);

	public static List<Airline> parseStringToAirlineList(String source) {

		if (source == null) {
			LOGGER.info("Null source string to parse");
			return new LinkedList<Airline>();
		}
		List<Airline> result = new LinkedList<>();

		@SuppressWarnings("resource")
		Scanner parser = new Scanner(source);
		String name = null;
		Airline airline = null;
		while (parser.hasNextLine()) {
			name = parser.nextLine();
			if (name.matches(AIRLINE_NAME_REGEX)) {
				airline = new Airline();
				airline.setName(name.replaceFirst(AIRLINE_NAME_REGEX, "$1"));
				result.add(airline);
			}
		}
		return result;
	}
}
