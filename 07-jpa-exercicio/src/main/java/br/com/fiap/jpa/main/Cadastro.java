package br.com.fiap.jpa.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.UsuarioDao;
import br.com.fiap.jpa.dao.impl.UsuarioDaoImpl;
import br.com.fiap.jpa.entity.CasoTeste;
import br.com.fiap.jpa.entity.ItemTeste;
import br.com.fiap.jpa.entity.Sistema;
import br.com.fiap.jpa.entity.Usuario;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Cadastro {

	//Cadastrar todas as entidades relacionadas
	public static void main(String[] args) {
		//Instanciar o sistema com o nome
		Sistema sistema = new Sistema("Minduim");
		
		//Instanciar o caso de teste com o nome, descrição e sistema
		CasoTeste caso = 
			new CasoTeste("Cadastro usuário", "Cadastrar o usuário com sucesso", sistema);
		
		//Instanciar um item teste com a descrição e o caso teste
		ItemTeste item = new ItemTeste("Cadastro de usuário", caso);
		
		//Criar a lista de itens de teste
		List<ItemTeste> lista = new ArrayList<ItemTeste>();
		lista.add(item);
		
		//Instanciar um usuário com o nome e a lista de item		
		Usuario usuario = new Usuario("fiap", lista);
		
		//Obter um entity manager
		EntityManager em = 
				EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar o UsuarioDao
		UsuarioDao dao  = new UsuarioDaoImpl(em);

		try {
			//O usuário cadastra o item teste, o item o caso e o caso o sistema em cascada
			dao.cadastrar(usuario);
			//Commit
			dao.commit();
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
	}
}