package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Funcionario;
import entity.Hospede;

public class LoginDao {
	private ConexaoBanco c = new ConexaoBanco();
	
	public boolean LoginHospede (int cpf, String senha) {
		int cpf2;
		String senha2;
		Connection con = c.getConnection();
		String query = "SELECT cpf, CAST(AES_DECRYPT(senha_hosp,'chave') as char) FROM hospede WHERE cpf = ?;";
		try {
			PreparedStatement ps = con.prepareStatement(query);			
			ps.setInt(1, cpf);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				cpf2 = resultSet.getInt(1);
				senha2 = resultSet.getString(2);
				if(cpf==cpf2 && senha.compareTo(senha2)==0) {
					return true;
				}else {
					return false;
				}					
			}			
			con.close();
			//return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean LoginFuncionario(int cpf, String senha) {
		int cpf2;
		String senha2;
		Connection con = c.getConnection();
		String query = "SELECT cpf_func, CAST(AES_DECRYPT(senha_func,'chave') as char) FROM funcionario WHERE cpf_func = ?;";
		try {
			PreparedStatement ps = con.prepareStatement(query);			
			ps.setInt(1, cpf);
			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {
				cpf2 = resultSet.getInt(1);
				senha2 = resultSet.getString(2);
				if(cpf==cpf2 && senha.compareTo(senha2)==0) {
					return true;
				}else {
					return false;
				}					
			}			
			con.close();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
