package br.com.fiap.jpa.main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Cliente;
import br.com.fiap.jpa.entity.Genero;

public class ExemploCadastro {
	
	public static void main(String[] args) {
		//Obter um objeto da fabrica de Entity Manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		//Obter um objeto do Entity maganer
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um Cliente
		Cliente cliente = new Cliente("Priscila", "asdfsdfa@fiap.com.br",new BigDecimal("1000"), 
											LocalDate.of(2000, Month.APRIL, 19), null, Genero.FEMININO);
		
		//Cadastrar um Cliente
		em.persist(cliente);
		
		//Começar uma transação
		em.getTransaction().begin();
		//Finalizar a transação com commit
		em.getTransaction().commit();
		
		System.out.println("Cliente cadastrado!");
		
		//Alterar o nome do cliente
		cliente.setNome("Leandro");
		
		//Commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Fechar os recursos
		em.close();
		fabrica.close();
		
	}
}
