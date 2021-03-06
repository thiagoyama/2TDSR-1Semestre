package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.TimeDao;
import br.com.fiap.jpa.dao.impl.TimeDaoImpl;
import br.com.fiap.jpa.entity.Jogador;
import br.com.fiap.jpa.entity.Patrocinio;
import br.com.fiap.jpa.entity.Time;
import br.com.fiap.jpa.exception.IdNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ExemploBusca {

	public static void main(String[] args) {
		//Criar a fabrica e entity manager
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Criar o TimeDao
		TimeDao timeDao = new TimeDaoImpl(em);
		
		try {
			//Pesquisar o time pelo codigo
			Time time = timeDao.procurar(1);
			
			//Exibir o nome do time
			System.out.println("Time: " + time.getNome());

			//Exibir o nome do t?cnico
			System.out.println("T?cnico: " + time.getTecnico().getNome());
			
			//Exibir o nome dos jogadores
			System.out.println("Jogadores:");
			for (Jogador jogador : time.getJogadores()) {
				System.out.println(jogador.getNome());
			}
			
			//Exibir os patrocinios do time
			System.out.println("Patrocinios:");
			for (Patrocinio item : time.getPatrocinios()) {
				System.out.println(item.getNomeMarca());
			}
			
		} catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}//main
}//class