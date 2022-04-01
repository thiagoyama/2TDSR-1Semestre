package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.GaragemDao;
import br.com.fiap.jpa.dao.impl.GaragemDaoImpl;
import br.com.fiap.jpa.entity.Garagem;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Exemplo {

	public static void main(String[] args) {
		//Obter uma fabrica de entity manager
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		
		//Obter o entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Criar a GaragemDaoImpl
		GaragemDao dao = new GaragemDaoImpl(em);
		
		//Instanciar a garagem sem código
		Garagem garagem = new Garagem("FIAP Park");
		
		try {
			//Cadastrar a garagem
			dao.cadastrar(garagem);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Pesquisar a garagem
			Garagem busca = dao.procurar(1);
			System.out.println(busca.getNome());
		}catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Atualizar a garagem
			garagem.setNome("Estacionamento Duke");
			dao.atualizar(garagem);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Remover a garagem
			dao.apagar(3);
			dao.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		em.close();
		fabrica.close();
	}
	
}
