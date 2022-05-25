package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.MedicoDao;
import br.com.fiap.jpa.entity.Medico;

public class MedicoDaoImpl extends GenericDaoImpl<Medico, Integer>
								implements MedicoDao {

	public MedicoDaoImpl(EntityManager em) {
		super(em);
	}

}
