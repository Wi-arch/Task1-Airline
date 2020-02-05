package by.education.airline.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import by.education.airline.entity.airline.Airline;

public class AirlineParser {

	private final static String AIRLINE_NAME_REGEX = "AirlineName=";

	public static List<Optional<Airline>> parseStringToAirlines(String source) {

		List<Optional<Airline>> result = new LinkedList<>();

		@SuppressWarnings("resource")
		Scanner parser = new Scanner(source);

		while (parser.hasNextLine()) {
			String name = parser.nextLine();
			if (name.matches(AIRLINE_NAME_REGEX + ".+")) {
				Airline airline = new Airline();
				airline.setName(name.replaceFirst(AIRLINE_NAME_REGEX, ""));
				result.add(Optional.ofNullable(airline));
			}
		}
		return result;
	}
}
