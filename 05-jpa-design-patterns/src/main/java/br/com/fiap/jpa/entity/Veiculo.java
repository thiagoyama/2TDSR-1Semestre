package br.com.fiap.jpa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_VEICULO")
@SequenceGenerator(name = "veiculo", sequenceName = "SQ_TB_VEICULO", allocationSize = 1)
public class Veiculo {

	@Id
	@Column(name = "cd_veiculo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veiculo")
	private Integer codigo;
	
	@Column(name="ds_modelo", length = 50, nullable = false)
	private String modelo;
	
	@Column(name="vl_veiculo")
	private BigDecimal valor;
	
	@Column(name="nr_ano")
	private Integer ano;
	
	@Column(name="dt_revisao")
	private LocalDate dataRevisao;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo", length = 30)
	private TipoVeiculo tipo;
	
	@Column(name="nr_placa", unique = true, length = 8)
	private String placa;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public LocalDate getDataRevisao() {
		return dataRevisao;
	}

	public void setDataRevisao(LocalDate dataRevisao) {
		this.dataRevisao = dataRevisao;
	}

	public TipoVeiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVeiculo tipo) {
		this.tipo = tipo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
}