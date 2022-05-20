package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ReservaDao;
import br.com.fiap.entity.Reserva;

public class ReservaDaoImpl extends GenericDaoImpl<Reserva,Integer> implements ReservaDao {

	public ReservaDaoImpl(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Reserva> buscarPorCpfCliente(String cpf) {
		return em.createNamedQuery("Reserva.porCpfCliente", Reserva.class)
				.setParameter("c", cpf)
				.getResultList();
	}

}
