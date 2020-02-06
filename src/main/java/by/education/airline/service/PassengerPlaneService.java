package by.education.airline.service;

import java.util.Set;

import org.apache.log4j.Logger;

import by.education.airline.entity.plane.PassengerPlane;
import by.education.airline.entity.plane.PassengerPlaneModel;
import by.education.airline.exception.RepositoryException;
import by.education.airline.exception.ServiceException;
import by.education.airline.repository.Repository;
import by.education.airline.repository.passengerplane.AddPassengerPlane;
import by.education.airline.repository.passengerplane.FindPassengerPlaneSetByCapacity;
import by.education.airline.repository.passengerplane.FindPassengerPlaneSetByModel;
import by.education.airline.repository.passengerplane.GetPassengerPlaneSet;
import by.education.airline.repository.passengerplane.PassengerPlaneRepositoryImpl;
import by.education.airline.specification.Specification;

public class PassengerPlaneService {

	private final static Logger LOGGER = Logger.getLogger(PassengerPlaneService.class);
	private final Repository<PassengerPlane> repository;
	private Specification<PassengerPlane> specification;
	private Set<PassengerPlane> passengerPlaneSet;

	private PassengerPlaneService() {
		repository = PassengerPlaneRepositoryImpl.INSTANCE;
	}

	public static PassengerPlaneService getInstance() {
		return PassengerPlaneServiceInstance.INSTANCE;
	}

	private static class PassengerPlaneServiceInstance {
		private final static PassengerPlaneService INSTANCE = new PassengerPlaneService();
	}

	public Set<PassengerPlane> getPassengerPlaneSetByCapacity(int passengerCapacity) throws ServiceException {

		specification = new FindPassengerPlaneSetByCapacity(passengerCapacity);
		try {
			passengerPlaneSet = repository.execute(specification);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
		return passengerPlaneSet;
	}

	public Set<PassengerPlane> getPassengerPlaneSetByModel(PassengerPlaneModel model) throws ServiceException {

		if (model == null) {
			throw new ServiceException("Null model");
		}
		specification = new FindPassengerPlaneSetByModel(model);
		try {
			passengerPlaneSet = repository.execute(specification);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
		return passengerPlaneSet;
	}

	public Set<PassengerPlane> getAllPassengerPlanes() throws ServiceException {

		specification = new GetPassengerPlaneSet();
		try {
			passengerPlaneSet = repository.execute(specification);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
		return passengerPlaneSet;
	}

	public void addPassengerPlane(PassengerPlane plane) throws ServiceException {

		if (plane == null) {
			LOGGER.warn("Null passenger plane");
			throw new ServiceException("Null passenger plane");
		}
		specification = new AddPassengerPlane(plane);
		try {
			repository.execute(specification);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
	}

}
