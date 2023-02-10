package br.ifpr.execucao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import br.ifpr.dao.PessoaDAO;
import br.ifpr.modelo.Pessoa;

public class PessoaBuscar {
	public static void main(String[] args) 
			throws IOException, NumberFormatException, SQLException {
		//1- Ler um ID de produto para ser buscado
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		
		System.out.println("Informe o ID do produto a ser buscado: ");
		String id = reader.readLine();
				
		//2- Chamar o metódo que retona o Produto (ProdutoDAO)
		PessoaDAO pesDao = new PessoaDAO();
		Pessoa pes = pesDao.buscar(Integer.parseInt(id));
		
		//3- Imprmir o produto (verificar se está nulo)
		if(pes != null)
			System.out.println(pes.retornaDadosPessoa());
		else //Produto NULL
			System.out.println("O Produto ID = " + id + " não foi encontrado.");

	}

}
