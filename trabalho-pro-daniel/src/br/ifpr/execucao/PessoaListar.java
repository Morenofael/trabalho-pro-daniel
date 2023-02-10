package br.ifpr.execucao;

import java.sql.SQLException;
import java.util.List;

import br.ifpr.dao.PessoaDAO;
import br.ifpr.modelo.Pessoa;

public class PessoaListar {
	public static void main(String[] args) throws SQLException {
		PessoaDAO pesDAO = new PessoaDAO();
		List<Pessoa> lista = pesDAO.listar();
		
		System.out.println(lista.size());
		/*for (Pessoa pessoa : lista) {
			System.out.println(pessoa);
		}*/
		
		for(int i=0; i<lista.size(); i++) {
			Pessoa pessoa = lista.get(i);
			System.out.println(pessoa);
		}
	}
}
