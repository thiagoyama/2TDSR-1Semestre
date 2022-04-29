package br.com.fiap.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_ITEM_TESTE")
@SequenceGenerator(name="item", sequenceName = "SQ_TAB_TESTE", allocationSize = 1)
public class ItemTeste {

	@Id
	@Column(name="cod_item_teste")
	@GeneratedValue(generator = "item", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	@Column(name="des_item_teste")
	private String descricao;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="cod_caso_teste")
	private CasoTeste casoTeste;
	
	@ManyToMany(mappedBy = "itensTeste")
	private List<Usuario> usuarios;

	public ItemTeste() {}
	
	public ItemTeste(String descricao, CasoTeste casoTeste) {
		super();
		this.descricao = descricao;
		this.casoTeste = casoTeste;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CasoTeste getCasoTeste() {
		return casoTeste;
	}

	public void setCasoTeste(CasoTeste casoTeste) {
		this.casoTeste = casoTeste;
	}
	
}
