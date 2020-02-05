package by.education.airline.repository;

import java.util.Set;

import by.education.airline.exception.RepositoryException;
import by.education.airline.specification.Specification;

public interface Repository<T> {

	public Set<T> execute(Specification<T> specification) throws RepositoryException;
}
