package br.fiap.com.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.ClienteDao;
import br.com.fiap.dao.PacoteDao;
import br.com.fiap.dao.ReservaDao;
import br.com.fiap.dao.TransporteDao;
import br.com.fiap.dao.impl.ClienteDaoImpl;
import br.com.fiap.dao.impl.PacoteDaoImpl;
import br.com.fiap.dao.impl.ReservaDaoImpl;
import br.com.fiap.dao.impl.TransporteDaoImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Reserva;
import br.com.fiap.entity.Transporte;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Pesquisas2 {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		// Criar o ClienteDao
		ClienteDao clienteDao = new ClienteDaoImpl(em);

		// Chamar o método de pesquisar por parte do nome
		List<Cliente> clientes = clienteDao.buscarPorParteNome("A");

		// Exibir o nome dos clientes
		for (Cliente c : clientes) {
			System.out.println(c.getNome());
		}
		
		// Contar a quantidade de clientes do estado do PR
		long qtd = clienteDao.contarPorEstado("PR");
		
		//Exibir a quantidade
		System.out.println("Quantidade de clientes por estado: " + qtd);
		
		//Instanciar um TransporteDao
		TransporteDao transporteDao = new TransporteDaoImpl(em);
		
		//Pesquisar um Trasnporte pelo código
		Transporte transporte = transporteDao.pesquisar(1);
		
		//Instanciar um PacoteDao
		PacoteDao pacoteDao = new PacoteDaoImpl(em);
		
		//Somar os preços dos pacotes pelo transporte
		double soma = pacoteDao.somarPrecoPorTransporte(transporte);
		
		//Exibir a soma
		System.out.println("A soma dos preços é: " + soma);
		
		//Instanciar a ReservaDao
		ReservaDao reservaDao = new ReservaDaoImpl(em);
		
		//Pesquisar as reservas por cpf do cliente
		List<Reserva> reservas = reservaDao.buscarPorCpfCliente("502");
		
		//Exibir a descrição do pacote da reserva e o nome do cliente
		for (Reserva r : reservas) {
			System.out.println(r.getPacote().getDescricao() + " " + r.getCliente().getNome());
		}
		
		//Pesquisar os pacotes com preço menor do que 2000
		List<Pacote> pacotes = pacoteDao.buscarPorPrecoMenor(2000d);
		
		//Exibir a descrição e o preço do pacote
		for (Pacote p : pacotes) {
			System.out.println(p.getDescricao() + " " + p.getPreco());
		}
		
		em.close();
		fabrica.close();
		
	}
}
