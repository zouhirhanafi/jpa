package ma.ensaf.jpa.dao.utils;

import java.util.List;

public interface IGenericDao<T> {

	T create(T entity);

	T update(T entity);

	void delete(T entity);

	void delete(Long id);

	T findOne(Long id);

	List<T> findAll();

}