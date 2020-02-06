package by.education.airline.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import by.education.airline.entity.airline.Airline;
import by.education.airline.exception.RepositoryException;

public class AirlineRepositoryTest {

	private Repository<Airline> repository = AirlineRepositoryImpl.INSTANCE;

	@Test
	public void testFindAirlineByNamePositive() throws RepositoryException {

		Airline actual = repository.execute(new FindAirlineByName("GoAir")).iterator().next();
		Airline expected = new Airline("GoAir");
		assertEquals(expected, actual);
	}

	@Test
	public void testFindAirlineByNameNegative() throws RepositoryException {

		Airline actual = repository.execute(new FindAirlineByName("GoAir")).iterator().next();
		Airline expected = new Airline("GoAirToToTo");
		assertNotEquals(expected, actual);
	}

	@Test
	public void testGetAirlineSetNegative() throws RepositoryException {

		int actual = repository.execute(new GetAirlineSet()).size();
		assertNotEquals(5, actual);
	}

	@Test
	public void testGetAirlineSetPositive() throws RepositoryException {

		int actual = repository.execute(new GetAirlineSet()).size();
		assertEquals(2, actual);
	}
}
