package by.education.airline.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import by.education.airline.entity.airline.Airline;
import by.education.airline.exception.RepositoryException;
import by.education.airline.repository.airline.AirlineRepositoryImpl;
import by.education.airline.repository.airline.FindAirlineByName;
import by.education.airline.repository.airline.GetAirlineSet;

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

	@Test(expected = RepositoryException.class)
	public void testFindAirlineByNameNegativeWithException() throws RepositoryException {
		Airline actual = repository.execute(null).iterator().next();
		Airline expected = new Airline("GoAirToToTo");
		assertNotEquals(expected, actual);
	}

	@Test
	public void testGetAirlineSetNegative() throws RepositoryException {
		int actual = repository.execute(new GetAirlineSet()).size();
		int expected = 5;
		assertNotEquals(expected, actual);
	}

	@Test
	public void testGetAirlineSetPositive() throws RepositoryException {
		int actual = repository.execute(new GetAirlineSet()).size();
		int expected = 2;
		assertEquals(expected, actual);
	}

	@Test(expected = RepositoryException.class)
	public void testGetAirlineSetNegativeWithException() throws RepositoryException {
		int actual = repository.execute(null).size();
		int expected = 2;
		assertEquals(expected, actual);
	}
}
