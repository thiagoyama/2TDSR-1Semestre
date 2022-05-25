package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.PacienteDao;
import br.com.fiap.jpa.entity.Paciente;

public class PacienteDaoImpl extends GenericDaoImpl<Paciente, Integer>
											implements PacienteDao {

	public PacienteDaoImpl(EntityManager em) {
		super(em);
	}

}
