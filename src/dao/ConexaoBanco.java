package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

	//private static volatile ConexaoBanco instance;
	private Connection connection;

	private final String SUB_PROTOCOLO = "mariadb";
	private final String HOSTNAME = "52.188.48.87";
	private final String PORT = "3306";
	private final String DATABASE_NAME = "bdclube";
	private final String USER = "projetobdclube";
	private final String PASSWORD = "senhaclube";

	ConexaoBanco() {
	};

	/*public static ConexaoBanco getInstance() {
		if (instance == null) {

			synchronized (ConexaoBanco.class) {

				if (instance == null) {

					instance = new ConexaoBanco();
				}
			}
		}
		return instance;
	}*/

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
