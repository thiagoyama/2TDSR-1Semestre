package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	//Relacionamento 1:1
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_tecnico",  nullable = false)
	private Tecnico tecnico;
	
	//Relacionamento bidirecional 1:N
	@OneToMany(mappedBy = "time", cascade = CascadeType.PERSIST)	
	private List<Jogador> jogadores = new ArrayList<Jogador>();
	
	//Relacionamento N:M
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name="TB_TIME_PATROCINIO",
		joinColumns = @JoinColumn(name="cd_time"),
		inverseJoinColumns = @JoinColumn(name="cd_patrocinio"))
	private List<Patrocinio> patrocinios;
	
	@Column(name="nm_time", length = 50, nullable = false)
	private String nome;
	
	@Column(name="nm_estadio", length = 50)
	private String nomeEstadio;
	
	public Time() {}

	public Time(Tecnico tecnico, String nome, String nomeEstadio) {
		this.tecnico = tecnico;
		this.nome = nome;
		this.nomeEstadio = nomeEstadio;
	}

	//Para relacionamento 1:N
	//M�todo que para garantir o preenchimento da FK
	public void addJogador(Jogador jogador) {
		//Seta o atributo que mapeia a FK
		jogador.setTime(this);
		//Adicionar o jogador na lista
		jogadores.add(jogador);
	}
	
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

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public List<Patrocinio> getPatrocinios() {
		return patrocinios;
	}

	public void setPatrocinios(List<Patrocinio> patrocinios) {
		this.patrocinios = patrocinios;
	}
	
}
