package br.ifpr.execucao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import br.ifpr.dao.PessoaDAO;
import br.ifpr.modelo.Pessoa;

public class PessoaExcluir {
	public static void main(String[] args) throws IOException, NumberFormatException, SQLException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Informe o ID da pessoa a ser excluído");

		String id = reader.readLine();
		Integer idInt = Integer.parseInt(id);
		

		PessoaDAO pesDAO = new PessoaDAO();
		Pessoa pes = pesDAO.buscar(idInt);
		if(pes != null) {

			pesDAO.excluir(idInt);
			System.out.println("Pessoa "+idInt+" excluído com sucesso.");
		}else {
			System.out.println("O ID "+id+" não pertence a nenhuma pessoa");
		}
	}
}
