package ma.ensaf.jpa.dao.utils;

import java.util.List;

import javax.persistence.EntityManager;

import ma.ensaf.jpa.utils.SimpleEntityManger;

public abstract class GenericDao<T> implements IGenericDao<T> {
	
	private EntityManager entityManager;

	protected abstract Class<T> getClazz();
	
	public GenericDao() {
		entityManager = SimpleEntityManger.getInstance().getEntityManager();
	}
	
	@Override
	public T create(T entity) {
//		entityManager.getTransaction().begin();
		entityManager.persist(entity);
//		entityManager.getTransaction().commit();
		return entity;
	}

	@Override
	public T update(T entity) {
		// creation de l'entité si la clé primaire est null, sinon il met a jour les informations
		entityManager.merge(entity);
		return entity;
	}

	@Override
	public void delete(T entity) {
		entityManager.remove(entity);
	}

	@Override
	public void delete(Long id) {
		T entity = findOne(id);
		delete(entity);
	}
	
	@Override
	public T findOne(Long id) {
		T entity = entityManager.find(getClazz(), id);
		return entity;
	}
	
	@Override
	public List<T> findAll() {
		List<T> list = entityManager.createQuery("from " + getClazz().getSimpleName()).getResultList();
		return list;
	}
}
