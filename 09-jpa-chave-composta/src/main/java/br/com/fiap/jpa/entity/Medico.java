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
@Table(name="TB_MEDICO")
@SequenceGenerator(name="medico", sequenceName = "SQ_TB_MEDICO", allocationSize = 1)
public class Medico {

	@Id
	@Column(name="cd_medico")
	@GeneratedValue(generator = "medico", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Column(name="nm_medico", length = 80, nullable = false)
	private String nome;
	
	@Column(name="nr_crm", nullable = false)
	private Integer crm;
	
	@OneToMany(mappedBy = "medico")
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

	public Integer getCrm() {
		return crm;
	}

	public void setCrm(Integer crm) {
		this.crm = crm;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	
}