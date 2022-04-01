package br.com.fiap.jpa.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.GaragemDao;
import br.com.fiap.jpa.entity.Garagem;

public class GaragemDaoImpl 
					extends GenericDaoImpl<Garagem, Integer> 
												implements GaragemDao {

	public GaragemDaoImpl(EntityManager em) {
		super(em);
	}

}
