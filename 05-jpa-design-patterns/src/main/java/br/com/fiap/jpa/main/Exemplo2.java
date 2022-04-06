package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.GenericDao;
import br.com.fiap.jpa.dao.impl.GenericDaoImpl;
import br.com.fiap.jpa.entity.Garagem;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Exemplo2 {

	// Utilizar o generic dao sem a herança
	public static void main(String[] args) {
		// Obter uma fabrica de entity manager
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();

		// Obter o entity manager
		EntityManager em = fabrica.createEntityManager();

		GenericDao<Garagem, Integer> dao =
				// Criando uma classe anonima e instanciando
				new GenericDaoImpl<Garagem, Integer>(em) {};
				
		em.close();
		fabrica.close();
	}

}
