package br.ifpr.execucao;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import br.ifpr.dao.PessoaDAO;
import br.ifpr.modelo.Pessoa;

public class PessoaCriar {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));
		
		Pessoa pes = new Pessoa();
		
		System.out.println("Informe o nome: ");
		String nome = reader.readLine();
		pes.setNome(nome);
		
		System.out.println("Informe o email: ");
		String email = reader.readLine();
		pes.setEmail(email);
		
		System.out.println("Informe o telefone: ");
		String telefone = reader.readLine();
		pes.setTelefone(telefone);
		
		System.out.println("Informe a altura: ");
		String altura = reader.readLine();
		pes.setAltura(Float.parseFloat(altura));
		
		System.out.println("Informe o peso: ");
		String peso = reader.readLine();
		pes.setAltura(Float.parseFloat(peso));
		
		System.out.println(pes.retornaDadosPessoa());
		//System.out.println(pes);
		
		//Salvar o objeto no banco de dados
		PessoaDAO prodDAO = new PessoaDAO();
		prodDAO.inserir(pes);
	}
}
