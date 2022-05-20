package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Reserva;

public interface ReservaDao extends GenericDao<Reserva,Integer>{

	List<Reserva> buscarPorCpfCliente(String cpf);
	
}
