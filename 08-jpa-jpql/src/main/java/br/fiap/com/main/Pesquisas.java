package br.fiap.com.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.PacoteDao;
import br.com.fiap.dao.impl.PacoteDaoImpl;
import br.com.fiap.entity.Pacote;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Pesquisas {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Criar o PacoteDao
		PacoteDao pacoteDao = new PacoteDaoImpl(em);
		
		//Chamar o método de listar
		//List<Pacote> pacotes = pacoteDao.listar();
		List<Pacote> pacotes = pacoteDao.buscarPorQuantidadeDias(1, 8);
		
		//Exibir a descrição dos pacotes
		for (Pacote p : pacotes) {
			System.out.println(p.getDescricao());
		}
		
	}//class
}//main