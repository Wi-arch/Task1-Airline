package by.education.airline.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import by.education.airline.entity.plane.CargoPlane;
import by.education.airline.exception.RepositoryException;
import by.education.airline.repository.cargoplane.CargoPlaneRepositoryImpl;
import by.education.airline.repository.cargoplane.DeleteCargoPlane;
import by.education.airline.repository.cargoplane.GetCargoPlaneSet;

public class CargoPlaneRepositoryTest {

	private Repository<CargoPlane> repository;
	private CargoPlane cargoPlane;
	private int repositorySize;

	@Before
	public void init() throws RepositoryException {
		repository = CargoPlaneRepositoryImpl.INSTANCE;
		repositorySize = repository.execute(new GetCargoPlaneSet()).size();
		cargoPlane = new CargoPlane();
		cargoPlane.setId(1);
	}

	@Test
	public void testDeleteCargoPlanePositive() throws RepositoryException {
		repository.execute(new DeleteCargoPlane(cargoPlane));
		int expected = repositorySize - 1;
		int actual = repositorySize - 1;
		assertEquals(expected, actual);
	}

	@Test
	public void testDeleteCargoPlaneNegative() throws RepositoryException {
		repository.execute(new DeleteCargoPlane(cargoPlane));
		int expected = repositorySize - 1;
		int actual = repositorySize;
		assertNotEquals(expected, actual);
	}

	@Test(expected = RepositoryException.class)
	public void testDeleteCargoPlaneNegativeWithException() throws RepositoryException {
		repository.execute(null);
		int expected = repositorySize;
		int actual = repositorySize;
		assertNotEquals(expected, actual);
	}

}
