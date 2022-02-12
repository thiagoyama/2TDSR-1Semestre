package br.com.fiap.revisao.main;

import br.com.fiap.revisao.model.Funcionario;
import br.com.fiap.revisao.model.FuncionarioTerceiro;

public class Teste {

	//Criar o método main
	public static void main(String[] args) {
		
		//Instanciar a classe Funcionario
		Funcionario fun = new Funcionario("João", 1000, 20, true, 7);
		
		//Setar os valores para o objeto
//		fun.setNome("João");
//		fun.setIdade(20);
//		fun.setEstagio(true);
//		fun.setMesesContratado(7);
//		fun.setSalario(2000);
		
		//Chamar os métodos e exibir o resultado
		fun.aumentarSalario();
		System.out.println("Salário atual: " + fun.getSalario());
		
		fun.efetivar();
		System.out.println(fun.isEstagio()?"Estágio":"Efetivado");
		System.out.println("Salário atual: " + fun.getSalario());
		
		//Instanciar a classe FuncionarioTerceiro passando os valores
		FuncionarioTerceiro ft = new FuncionarioTerceiro("Maria", 1000, 21, true, 5, 10);
		
		//Chamar os métodos e exibir o resultado
		ft.aumentarSalario();
		System.out.println("Salário atual do funcionário terceiro: " + ft.getSalario());
		
		ft.efetivar();
		System.out.println(ft.isEstagio()?"Estágio":"Efetivado");
		System.out.println("Salário atual do funcionário terceiro: " + ft.getSalario());
		
		//FuncionarioTerceiro ft2 = new Funcionario("Raissa", 1000); //Não compila!
		
		Funcionario fun2 = new FuncionarioTerceiro("Everton", 1000);
		fun2.aumentarSalario(); //Executa qual implementação? FuncionarioTerceiro
		System.out.println(fun2.getSalario());
		
	}//main
}//class