package br.com.fiap.jpa.view;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ConsultaDao;
import br.com.fiap.jpa.dao.MedicoDao;
import br.com.fiap.jpa.dao.PacienteDao;
import br.com.fiap.jpa.dao.impl.ConsultaDaoImpl;
import br.com.fiap.jpa.dao.impl.MedicoDaoImpl;
import br.com.fiap.jpa.dao.impl.PacienteDaoImpl;
import br.com.fiap.jpa.entity.Consulta;
import br.com.fiap.jpa.entity.Medico;
import br.com.fiap.jpa.entity.Paciente;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Main {

	//Cadastrar o médico, paciente e a consulta
	public static void main(String[] args) {
		//Instanciar o médico, paciente e a consulta
		Medico medico = new Medico();
		medico.setNome("Drauzio");
		medico.setCrm(23423);
		
		Paciente paciente = new Paciente();
		paciente.setNome("Raissa");
		
		Consulta consulta = new Consulta();
		consulta.setMedico(medico);
		consulta.setPaciente(paciente);
		consulta.setData(LocalDateTime.of(2022, 7, 15, 10, 0));
		
		//Obter o Entity Manager
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar o Dao da consulta, médico e paciente
		ConsultaDao consultaDao = new ConsultaDaoImpl(em);
		MedicoDao medicoDao = new MedicoDaoImpl(em);
		PacienteDao pacienteDao = new PacienteDaoImpl(em);
		
		//Cadastrar o médico 
		medicoDao.cadastrar(medico);
		
		//Cadastrar o paciente
		pacienteDao.cadastrar(paciente);
		
		//Cadastrar a consulta
		consultaDao.cadastrar(consulta);
		
		//Commit
		try {
			consultaDao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		//Sucesso! =D
	}
}