package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.ConsultaDao;
import br.com.fiap.jpa.entity.Consulta;
import br.com.fiap.jpa.entity.ConsultaPk;

public class ConsultaDaoImpl extends GenericDaoImpl<Consulta, ConsultaPk>
								implements ConsultaDao {

	public ConsultaDaoImpl(EntityManager em) {
		super(em);
	}

}
