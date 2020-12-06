package dao;

import java.sql.*;
import java.sql.Statement;
//teste
public class Teste {
	public static void main(String[] args) {
		ConexaoBanco c = new ConexaoBanco();
		Connection con = c.getConnection();
		try {
			Statement st = con.createStatement();
			String sql = "INSERT INTO hospede (cpf, nome, email, endereco, telefone, senha_hosp) "
					+ "VALUES ('2111111112', 'teste', 'teste', 'teste', '11111111', AES_ENCRYPT('teste', 'chave'))";
			int i = st.executeUpdate(sql);
			System.out.printf("Insert executado %d linhas foram afetadas%n", i);
			con.close();
			System.out.println("Conexão fechada");		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
