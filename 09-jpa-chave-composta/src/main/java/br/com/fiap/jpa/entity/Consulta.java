package br.com.fiap.jpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_CONSULTA")
@IdClass(ConsultaPk.class)//Define a classe que mapeia a PK composta
public class Consulta {

	@Id
	@ManyToOne
	@JoinColumn(name="cd_medico")
	private Medico medico;
	
	@Id
	@ManyToOne
	@JoinColumn(name="cd_paciente")
	private Paciente paciente;
	
	@Id
	@Column(name="dt_consulta")
	private LocalDateTime data;
	
	@Column(name="ds_observacoes")
	private String observacoes;

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
}