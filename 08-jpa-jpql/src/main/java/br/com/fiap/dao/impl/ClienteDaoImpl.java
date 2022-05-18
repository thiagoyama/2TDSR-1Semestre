package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDao;
import br.com.fiap.entity.Cliente;

public class ClienteDaoImpl extends GenericDaoImpl<Cliente,Integer> implements ClienteDao{

	public ClienteDaoImpl(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Cliente> buscarPorParteNome(String nome) {
		return em.createQuery("from Cliente c where lower(c.nome) like lower(:n) order by c.nome", Cliente.class)				
				.setParameter("n", "%" + nome + "%")
				.getResultList();
	}

	public List<Cliente> buscarPorEstado(String estado) {
		return em.createQuery("from Cliente c where c.endereco.cidade.uf = :e", Cliente.class)
				.setParameter("e", estado)
				.getResultList();
	}

	public List<Cliente> buscarPorQuantidadeDiasReserva(Integer qtd) {
		return em.createQuery("select r.cliente from Reserva r where r.numeroDias = :d", Cliente.class)
				.setParameter("d", qtd)
				.setMaxResults(10) //máximo de resultados
				.getResultList();
	}

	public List<Cliente> buscar(String nome, String cidade) {
		return em.createQuery("from Cliente c where c.nome like :n and "
				+ "c.endereco.cidade.nome like :cid", Cliente.class)
				.setParameter("n", "%" + nome + "%")
				.setParameter("cid", "%" + cidade  + "%")
				.getResultList();
	}

	public List<Cliente> buscarPorEstados(List<String> estados) {
		return em.createQuery("from Cliente churros where "
				+ "churros.endereco.cidade.uf in :e", Cliente.class)
				.setParameter("e", estados)
				.getResultList();
	}

	public Long contarPorEstado(String estado) {		
		return em.createQuery("select count(c) from Cliente c where c.endereco.cidade.uf = :u", Long.class)
				.setParameter("u", estado)
				.getSingleResult();
	}

}








