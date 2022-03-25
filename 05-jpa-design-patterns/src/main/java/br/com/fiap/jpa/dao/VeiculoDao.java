package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Veiculo;

public interface VeiculoDao {

	void cadastrar(Veiculo veiculo);
	
	Veiculo procurar(Integer id);
	
	void atualizar(Veiculo veiculo);
	
	void apagar(Integer id);
	
	void commit();
	
}