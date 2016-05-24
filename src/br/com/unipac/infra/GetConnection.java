package br.com.unipac.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	private static final String DB_USER = "";
	private static final String DB_PASSWORD = "";
	private static final String BD_CONNECTION = "jdbc:h2:~/biblioteca";
	private static final String DB_DRIVER = "org.h2.Driver";

	Connection connection = null;
	
	public Connection abreConexao() {
		try {
			Class.forName(DB_DRIVER);
			connection = DriverManager.getConnection(BD_CONNECTION, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		return connection;
	}

	public void closeConexao(){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
