package br.com.fiap.main;

import java.lang.reflect.Field;
import br.com.fiap.model.Produto;

public class Exemplo {
	
	public static void main(String[] args) {
		//Instanciar um Produto
		Produto produto = new Produto();
		
		//API Reflection
		//Exibir o nome da classe do objeto
		System.out.println(produto.getClass().getName());
		
		//Recuperar os atributos do objeto
		Field[] atributos = produto.getClass().getDeclaredFields();
		
		//Exibir os nomes e os tipos
				
		//Recuperar os métodos do objeto
				
		//Exibir os nomes dos métodos
				
	}
}