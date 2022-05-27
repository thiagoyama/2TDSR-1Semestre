package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.GenericDao;
import br.com.fiap.jpa.dao.impl.GenericDaoImpl;
import br.com.fiap.jpa.entity.Pessoa;
import br.com.fiap.jpa.entity.PessoaFisica;
import br.com.fiap.jpa.entity.PessoaJuridica;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Main {

	public static void main(String[] args) {
		//Obter a fabrica
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		//Obter o EntityManager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um GenericDao para a Pessoa
		GenericDao<Pessoa,Integer> dao = new GenericDaoImpl<Pessoa, Integer>(em) {};
		
		//Instanciar uma Pessoa, PessoaFisica e PessoaJuridica
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Raissa");
		
		PessoaFisica pf = new PessoaFisica();
		pf.setNome("Silva");
		pf.setCpf("121.123.123-22");
		
		PessoaJuridica pj = new PessoaJuridica();
		pj.setNome("FIAP");
		pj.setCnpj("23.654.121/0001-62");
		
		//Cadastrar as pessoas
		dao.cadastrar(pessoa);
		dao.cadastrar(pj);
		dao.cadastrar(pf);
		
		try {
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
	}
}