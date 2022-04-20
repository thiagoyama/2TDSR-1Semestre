package br.com.fiap.jpa.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PATROCINIO")
@SequenceGenerator(name="pat", sequenceName = "SQ_TB_PATROCINIO", allocationSize = 1)
public class Patrocinio {

	@Id
	@Column(name="cd_patrocinio")
	@GeneratedValue(generator = "pat", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Column(name="nm_marca", length = 100, nullable = false)
	private String nomeMarca;
	
	@Column(name="dt_fim_contrato")
	private LocalDate dataFimContrato;
	
	//N:M bidirecional
	@ManyToMany(mappedBy = "patrocinios")
	private List<Time> times;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	public LocalDate getDataFimContrato() {
		return dataFimContrato;
	}

	public void setDataFimContrato(LocalDate dataFimContrato) {
		this.dataFimContrato = dataFimContrato;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}
	
}
