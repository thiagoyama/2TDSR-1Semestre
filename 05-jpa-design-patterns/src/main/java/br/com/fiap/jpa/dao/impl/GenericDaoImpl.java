package br.com.fiap.jpa.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.GenericDao;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;

public abstract class GenericDaoImpl<T,K> implements GenericDao<T, K> {
	
	private EntityManager em;
	
	private Class<T> clazz; //atributo que armazena o .class da Entidade
	
	@SuppressWarnings("all")
	public GenericDaoImpl(EntityManager em) {
		this.em = em;
		this.clazz = (Class<T>) 
				((ParameterizedType) getClass().getGenericSuperclass())
						.getActualTypeArguments()[0];
	}

	public void cadastrar(T entity) {
		em.persist(entity);
	}

	public T procurar(K id) throws IdNotFoundException {
		T entity = em.find(clazz, id);
		if (entity == null)
			throw new IdNotFoundException();
		return entity;
	}

	public void atualizar(T entity) {
		em.merge(entity);
	}

	public void apagar(K id) throws IdNotFoundException {
		em.remove(procurar(id));
	}

	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}

}