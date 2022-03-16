package br.com.fiap.jpa.main;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.fiap.jpa.entity.Cliente;
import br.com.fiap.jpa.entity.Genero;

public class ExemploAtualizacao {

	public static void main(String[] args) {
		//Obter uma fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		
		//Obter um entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um cliente com o código (detached)
		Cliente cliente = new Cliente(2, "Daniel Jorge 2", "jorge@gmail.com", 
							new BigDecimal("500"), LocalDate.now() , null, Genero.MASCULINO);
		
		//Atualizar no banco
		//Retorna a cópia do objeto gerenciado
		Cliente copia = em.merge(cliente);
		
		//Commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		copia.setNome("Rafael");
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		//Fechar
		em.close();
		fabrica.close();
		
	}
}