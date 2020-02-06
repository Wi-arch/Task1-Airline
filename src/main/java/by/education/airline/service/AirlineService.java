package by.education.airline.service;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

import org.apache.log4j.Logger;

import by.education.airline.entity.airline.Airline;
import by.education.airline.entity.plane.AbstractPlane;
import by.education.airline.entity.plane.CargoPlane;
import by.education.airline.entity.plane.PassengerPlane;
import by.education.airline.exception.RepositoryException;
import by.education.airline.exception.ServiceException;
import by.education.airline.repository.Repository;
import by.education.airline.repository.airline.AddAirline;
import by.education.airline.repository.airline.AirlineRepositoryImpl;
import by.education.airline.repository.airline.FindAirlineByName;
import by.education.airline.repository.airline.FindAirlineSetByNumberOfPlanes;
import by.education.airline.repository.airline.GetAirlineSet;
import by.education.airline.repository.airline.SortPlaneSetInAirline;
import by.education.airline.specification.Specification;
import by.education.airline.validator.CargoPlaneValidator;
import by.education.airline.validator.PassengerPlaneValidator;

public class AirlineService {

	private static final Logger LOGGER = Logger.getLogger(AirlineService.class);
	private final Repository<Airline> repository;
	private Specification<Airline> specification;
	private Set<Airline> airlineSet;

	private AirlineService() {
		repository = AirlineRepositoryImpl.INSTANCE;
	}

	private static class AirlineServiceInstance {
		private final static AirlineService INSTANCE = new AirlineService();
	}

	public static AirlineService getInstance() {
		return AirlineServiceInstance.INSTANCE;
	}

	public double getTotalCarryingCapacity(Airline airline) throws ServiceException {

		if (airline == null) {
			LOGGER.warn("Null input airline");
			throw new ServiceException("Null airline");
		}
		double totalCapacity = 0;
		for (AbstractPlane plane : airline.getAllPlanes()) {
			if (CargoPlaneValidator.isThePlaneCargoPlane(plane)) {
				CargoPlane temp = (CargoPlane) plane;
				totalCapacity += temp.getCarryingCapacity();
			}
		}
		return totalCapacity;
	}

	public int getTotalPassengersCapacity(Airline airline) throws ServiceException {

		if (airline == null) {
			LOGGER.warn("Null input airline");
			throw new ServiceException("Null airline");
		}
		int totalCapacity = 0;

		for (AbstractPlane plane : airline.getAllPlanes()) {
			if (PassengerPlaneValidator.isThePlanePassengerPlane(plane)) {
				PassengerPlane temp = (PassengerPlane) plane;
				totalCapacity += temp.getCapacity();
			}
		}
		return totalCapacity;
	}

	public Set<Airline> getAirlineSetByNumberOfPlanes(int planesNumber) throws ServiceException {

		specification = new FindAirlineSetByNumberOfPlanes(planesNumber);
		try {
			airlineSet = repository.execute(specification);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
		return airlineSet;
	}

	public void addAirline(Airline airline) throws ServiceException {

		if (airline == null) {
			LOGGER.warn("Null input airline");
			throw new ServiceException("Null airline");
		}
		specification = new AddAirline(airline);
		try {
			repository.execute(specification);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
	}

	public Set<Airline> getAllAirlines() throws ServiceException {

		specification = new GetAirlineSet();
		try {
			airlineSet = repository.execute(specification);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
		return airlineSet;
	}

	public Set<Airline> getAirlineByName(String airlineName) throws ServiceException {

		if (airlineName == null) {
			LOGGER.warn("Null input airline");
			throw new ServiceException("Null airline name");
		}
		specification = new FindAirlineByName(airlineName);
		try {
			airlineSet = repository.execute(specification);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
		return airlineSet;
	}

	public void sortPlaneListInAirline(Optional<String> airlineName, Comparator<AbstractPlane> comparator)
			throws ServiceException {

		if (airlineName == null || comparator == null) {
			LOGGER.warn("Null input airline or comarator");
			throw new ServiceException("Null airline");
		}
		specification = new SortPlaneSetInAirline(airlineName, comparator);
		try {
			repository.execute(specification);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
	}
}
