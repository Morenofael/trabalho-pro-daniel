package br.ifpr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ifpr.modelo.Pessoa;
import br.ifpr.util.Conexao;

public class PessoaDAO {
	public void inserir(Pessoa pes) throws SQLException {
		String sql = 
		"INSERT INTO pessoas (id,nome,email,telefone,altura,peso)" +
		" VALUES (?, ?);";
		
		Connection conn = Conexao.getConexao();
		
		PreparedStatement ps = 
				conn.prepareStatement(sql);
		ps.setString(1, pes.getNome());
		ps.setString(2, pes.getEmail());
		ps.setString(3, pes.getTelefone());
		ps.setFloat(4, pes.getAltura());
		ps.setFloat(5, pes.getPeso());
		
		ps.executeUpdate();
		
		conn.close();
	}
	
	public List<Pessoa> listar() throws SQLException {
		String sql = 
			"SELECT id_produto, descricao, unidade_medida" +
			" FROM produtos";
		
		Connection conn = Conexao.getConexao();
		
		PreparedStatement ps = 
				conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Pessoa> lista = new ArrayList<>();
		
		while(rs.next()) {
			Pessoa pes = new Pessoa();
			pes.setAltura(rs.getFloat("altura"));
			pes.setEmail(rs.getString("email"));
			pes.setNome(rs.getString("nome"));
			pes.setPeso(rs.getFloat("peso"));
			pes.setTelefone(rs.getString("telefone"));
			lista.add(pes);
		}
		
		conn.close();
		
		return lista;		
	}
	
	public Pessoa buscar(Integer id) throws SQLException {
		Pessoa pes = null;
		
		String sql = 
				"SELECT id_produto, descricao, unidade_medida" +
				" FROM produtos WHERE id_produto = ?";
		
		Connection conn = Conexao.getConexao();
		
		PreparedStatement ps = 
				conn.prepareStatement(sql);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		//Verificar se encontrou algum registro (produto)
		if(rs.next()) {
			//Criar e retornar um produto
			pes = new Pessoa();
			pes.setAltura(rs.getFloat("altura"));
			pes.setEmail(rs.getString("email"));
			pes.setNome(rs.getString("nome"));
			pes.setPeso(rs.getFloat("peso"));
			pes.setTelefone(rs.getString("telefone"));
			
		} 
		
		conn.close();
		
		return pes; //Se não encontrado, prod sera null	
	}
	public void excluir(Integer idProduto) throws SQLException {
		String sql = "DELETE FROM produtos WHERE id_produto = ?";
		Connection conn = Conexao.getConexao();
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, idProduto);
		ps.executeUpdate();
		conn.close();
	}
}
