package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PACIENTE")
@SequenceGenerator(name="paciente", sequenceName = "SQ_TB_PACIENTE", allocationSize = 1)
public class Paciente {

	@Id
	@Column(name="cd_paciente")
	@GeneratedValue(generator = "paciente", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Column(name="nm_paciente", nullable = false, length = 80)
	private String nome;
	
	@OneToMany(mappedBy = "paciente")
	private List<Consulta> consultas;

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

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	
}
