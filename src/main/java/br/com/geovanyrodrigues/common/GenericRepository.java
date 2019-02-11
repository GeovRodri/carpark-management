package br.com.geovanyrodrigues.common;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

@Transactional(propagation = Propagation.MANDATORY)
public abstract class GenericRepository<T, I extends Serializable> {

	@PersistenceContext
	protected EntityManager entityManager;
	private Class<T> persistedClass;

	protected GenericRepository() { }

	protected GenericRepository(Class<T> persistedClass) {
		this();
		this.persistedClass = persistedClass;
	}

	@Transactional
	public T save(T entity) {
		entityManager.persist(entity);
		entityManager.flush();
		return entity;
	}

	@Transactional
	public T update(T entity) {
		entityManager.merge(entity);
		entityManager.flush();
		return entity;
	}

	@Transactional
	public void remove(I id) {
		T entity = get(id);
		T mergedEntity = entityManager.merge(entity);
		entityManager.remove(mergedEntity);
		entityManager.flush();
	}

	@Transactional(readOnly=true)
	public List<T> get() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(persistedClass);
		query.from(persistedClass);
		return entityManager.createQuery(query).getResultList();
	}

	@Transactional(readOnly=true)
	public T get(I id) {
		return entityManager.find(persistedClass, id);
	}
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}
}