package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

	private Connection connection;

	

	ConexaoBanco() {
	};	

	public Connection getConnection() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String URLCON = "jdbc:mariadb://localhost:3306/hotel";
			String USER = "root";
			String PASS = "";
			Connection con = DriverManager.getConnection(URLCON, USER, PASS);
			System.out.println("Conexão Criada");
			/*connection = DriverManager.getConnection(
					"jdbc:" + SUB_PROTOCOLO + "://" + HOSTNAME + ":" + PORT + "/" + DATABASE_NAME, USER, PASSWORD);*/

			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro no sql");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Erro na classe");
		}
		return null;
	}

	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
