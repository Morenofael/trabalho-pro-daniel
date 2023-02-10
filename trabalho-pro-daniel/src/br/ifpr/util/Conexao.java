package br.ifpr.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static Connection getConexao() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/pedidos",
				"root", "bancodedados");
		} catch (SQLException e) {
			System.out.println("Erro ao conectar na base de dados.");
			e.printStackTrace();
		}
		
		return conn;
	}
}
