package br.fiap.com.main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.ClienteDao;
import br.com.fiap.dao.PacoteDao;
import br.com.fiap.dao.TransporteDao;
import br.com.fiap.dao.impl.ClienteDaoImpl;
import br.com.fiap.dao.impl.PacoteDaoImpl;
import br.com.fiap.dao.impl.TransporteDaoImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;
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
		
		//Criar o ClienteDao
		ClienteDao clienteDao = new ClienteDaoImpl(em);
		
		//Chamar o método de pesquisar por parte do nome
		List<Cliente> clientes = clienteDao.buscarPorParteNome("Paulo");
		
		//Exibir o nome dos clientes
		for (Cliente c : clientes) {
			System.out.println(c.getNome());
		}
		
		//Criar o TransporteDao
		TransporteDao trasporteDao = new TransporteDaoImpl(em);
		
		//Pesquisar um transporte pela código
		Transporte transporte = trasporteDao.pesquisar(1);
		
		//Pesquisar os pacotes por transporte
		pacotes = pacoteDao.buscarPorTransporte(transporte);
				
		//Exibir a descrição do pacote e a empresa do transporte
		for (Pacote p : pacotes) {
			System.out.println(p.getDescricao() 
								+ " " + p.getTransporte().getEmpresa());
		}
		
		//Pesquisar os clientes por estado
		clientes = clienteDao.buscarPorEstado("PR");
		
		//Exibir o nome dos clientes e o estado
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome() 
					+ " " + cliente.getEndereco().getCidade().getUf());
		}
		
		//Pesquisar os clientes por quantidade de dias de reserva
		clientes = clienteDao.buscarPorQuantidadeDiasReserva(10);
		
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		
		//Listar os 3 primeiros clientes
		clientes = clienteDao.listar(0 , 3);
		
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome());
		}
		
		Calendar inicio = new GregorianCalendar(2021, Calendar.APRIL, 10);
		Calendar inicio = new GregorianCalendar(2021, Calendar.APRIL, 10);
		
		//Pesquisar o pacote por datas
		
		
		//Exibir a descrição do pacote
		
		
	}//class
}//main
