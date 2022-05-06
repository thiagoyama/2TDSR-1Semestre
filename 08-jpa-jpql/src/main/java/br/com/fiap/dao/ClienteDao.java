package br.com.fiap.dao;

import java.util.List;
import br.com.fiap.entity.Cliente;

public interface ClienteDao extends GenericDao<Cliente,Integer>{

	List<Cliente> buscarPorParteNome(String nome);
	
	List<Cliente> buscarPorEstado(String estado);
	
}
