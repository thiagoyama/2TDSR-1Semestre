package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Cliente;

public class ExemploRefresh {

	public static void main(String[] args) {
		//1-Obter uma fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		//2-Obter um entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//3-Pesquisar um cliente pelo codigo
		Cliente cliente = em.find(Cliente.class, 1);
		
		//4-Exibir o nome do cliente
		System.out.println(cliente.getNome());
		
		//5-Setar o nome do cliente
		cliente.setNome("TESTE MARIA");
		
		//6-Exibir o nome do cliente
		System.out.println(cliente.getNome());
		
		//7-Chamar o método refresh
		em.refresh(cliente);
		
		//8-Exibir o nome do cliente
		System.out.println(cliente.getNome());
		
		//9-Fechar
		em.close();
		fabrica.close();
	}
}