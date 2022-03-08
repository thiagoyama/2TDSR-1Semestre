package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_CLIENTE")
					//nome no Java, nome no banco, incremento
@SequenceGenerator(name="cliente", sequenceName = "SQ_TB_CLIENTE", allocationSize = 1)
public class Cliente {

	@Id
	@Column(name="cd_cliente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
	private Integer codigo;
	
	@Column(name="nm_cliente", length = 80, nullable = false) //nullable -> pode ser nulo?
	private String nome;
	
	@Column(name="ds_email", unique = true, length = 50)
	private String email;
	
	@Column(name="dt_cadastro", nullable = false, updatable = false) //updatable -> será atualizado?
	private Calendar dataCadastro;
	
	@Column(name="st_ativo", insertable = false)//insertable -> será cadastrado?
	private Boolean ativo;
	
}