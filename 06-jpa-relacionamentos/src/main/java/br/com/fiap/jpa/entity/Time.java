package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_TIME")
@SequenceGenerator(name="time",sequenceName = "SQ_TB_TIME", allocationSize = 1)
public class Time {

	@Id
	@Column(name="cd_time")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "time")
	private Integer codigo;
	
	@Column(name="nm_time", length = 50, nullable = false)
	private String nome;
	
	@Column(name="nm_estadio", length = 50)
	private String nomeEstadio;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeEstadio() {
		return nomeEstadio;
	}

	public void setNomeEstadio(String nomeEstadio) {
		this.nomeEstadio = nomeEstadio;
	}
	
}
