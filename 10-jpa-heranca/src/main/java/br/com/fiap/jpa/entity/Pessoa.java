package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

//SINGLE_TABLE -> uma única tabela para toda a hierarquia

@Entity
@Table(name="TB_PESSOA")
@SequenceGenerator(name = "pessoa", sequenceName = "SQ_TB_PESSOA", allocationSize = 1)
public class Pessoa {

	@Id
	@Column(name="cd_pessoa")
	@GeneratedValue(generator = "pessoa", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Column(name="nm_pessoa", nullable = false, length = 80)
	private String nome;

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
	
}
