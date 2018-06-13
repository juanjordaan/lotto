package org.ts.game.infrastructure.persistence.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.ts.game.domain.model.AbstractEntity;

/**
 * @author juan
 *
 */
@Transactional
public class AbstractJPARepository<T extends AbstractEntity, Id extends Serializable> {
	private static final Logger LOG = LoggerFactory.getLogger(AbstractJPARepository.class);
	protected final Class<T> persistentClass;
	protected final Class<Id> idClass;
	
	@Autowired
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	protected AbstractJPARepository() {
		this.persistentClass = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.idClass = (Class<Id>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	public T create(T entity) {
		LOG.debug("create persistentClass=" + persistentClass + ",entity="+entity);
		
		em.persist(entity);
		
		LOG.info("created "+ entity);
		
		return entity;
	}
	
	public T findById(Id id) {
		LOG.debug("findById persistentClass=" + persistentClass + ",Id="+id);
		
		T entity = em.find(persistentClass, id);
		
		LOG.info("findById persistentClass=" + persistentClass + ",returning="+entity);
		
		return entity;
	}
	
	public T update(T entity) {
		LOG.debug("update persistentClass=" + persistentClass + ",entity="+entity);
		
		entity = em.merge(entity);
		
		LOG.info("update persistentClass=" + persistentClass + ",returning="+entity);
		
		return entity;
	}
	
	public T deleteById(Id id) {
		LOG.debug("deleteById persistentClass=" + persistentClass + ",Id="+id);
		
		T entity = em.find(persistentClass, id);
		
		em.remove(entity);
		
		LOG.debug("deleteById persistentClass=" + persistentClass + ",removed="+entity);
		
		return entity;
	}
}
