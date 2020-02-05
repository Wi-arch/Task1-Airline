package by.education.airline.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import by.education.airline.criterion.airline.AirlineCriterion;
import by.education.airline.entity.airline.Airline;
import by.education.airline.exception.RepositoryException;

public interface AirlineRepository {

	public void addAirline(Airline airline) throws RepositoryException;

	public void updateAirline(Airline airline) throws RepositoryException;

	public Optional<Airline> removeAirline(Airline airline) throws RepositoryException;

	public List<? extends Optional<Airline>> getAllAirlines() throws RepositoryException;

	public Set<Airline> execute(AirlineCriterion criterion) throws RepositoryException;
}
