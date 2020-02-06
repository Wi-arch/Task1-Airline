package by.education.airline.service;

import java.util.Set;

import org.apache.log4j.Logger;

import by.education.airline.entity.plane.CargoPlane;
import by.education.airline.exception.RepositoryException;
import by.education.airline.exception.ServiceException;
import by.education.airline.repository.AddCargoPlane;
import by.education.airline.repository.CargoPlaneRepositoryImpl;
import by.education.airline.repository.FindCargoPlaneSetByCarryingCapacity;
import by.education.airline.repository.FindCargoPlaneSetByFuelConsumptionRange;
import by.education.airline.repository.GetCargoPlaneSet;
import by.education.airline.repository.Repository;
import by.education.airline.specification.Specification;

public class CargoPlaneService {

	private final static Logger LOGGER = Logger.getLogger(CargoPlaneService.class);
	private final Repository<CargoPlane> repository;
	private Specification<CargoPlane> specification;
	private Set<CargoPlane> cargoPlaneSet;

	private CargoPlaneService() {
		repository = CargoPlaneRepositoryImpl.INSTANCE;
	}

	public static CargoPlaneService getInstance() {
		return CargoPlaneServiceInstance.INSTANCE;
	}

	private static class CargoPlaneServiceInstance {
		private final static CargoPlaneService INSTANCE = new CargoPlaneService();
	}

	public Set<CargoPlane> getCargoPlaneSetByFuelConsumptionRange(double minFuelConsumption, double maxFuelConsumption)
			throws ServiceException {

		specification = new FindCargoPlaneSetByFuelConsumptionRange(minFuelConsumption, maxFuelConsumption);
		try {
			cargoPlaneSet = repository.execute(specification);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
		return cargoPlaneSet;
	}

	public Set<CargoPlane> getCargoPlaneSetByCarringCapacity(double carryingCapacity) throws ServiceException {

		specification = new FindCargoPlaneSetByCarryingCapacity(carryingCapacity);
		try {
			cargoPlaneSet = repository.execute(specification);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
		return cargoPlaneSet;
	}

	public Set<CargoPlane> getAllCargoPlanes() throws ServiceException {

		specification = new GetCargoPlaneSet();
		try {
			cargoPlaneSet = repository.execute(specification);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
		return cargoPlaneSet;
	}

	public void addCargoPlane(CargoPlane cargoPlane) throws ServiceException {

		if (cargoPlane == null) {
			LOGGER.warn("Null cargo plane");
			throw new ServiceException("Null cargo plane");
		}
		specification = new AddCargoPlane(cargoPlane);
		try {
			repository.execute(specification);
		} catch (RepositoryException e) {
			throw new ServiceException(e);
		}
	}
}
