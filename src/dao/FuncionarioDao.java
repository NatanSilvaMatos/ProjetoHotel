package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Funcionario;

public class FuncionarioDao {
	private ConexaoBanco c = new ConexaoBanco();	

	public List<Funcionario> Pesquisa() {
		List<Funcionario> funcionarios = new ArrayList<>();
		Connection con = c.getConnection();
		String queryPessoa = "SELECT * FROM funcionario;";
		try {
			PreparedStatement ps = con.prepareStatement(queryPessoa);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				Funcionario funcionario = BancoEntity(resultSet);

				funcionarios.add(funcionario);
			}
			con.close();
			return funcionarios;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Funcionario PesquisaCpf(int cpf) {
		Funcionario funcionario = new Funcionario();
		Connection con = c.getConnection();
		String queryPessoa = "SELECT * FROM funcionario WHERE cpf_func = ?;";
		try {
			PreparedStatement ps = con.prepareStatement(queryPessoa);
			ps.setInt(1, cpf);
			ResultSet resultSet = ps.executeQuery();


				funcionario = BancoEntity(resultSet);
			
			con.close();
			return funcionario;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void Insert(Funcionario funcionario) {
		try {

			Connection con = c.getConnection();
			String queryhospede = "Insert Into funcionario(cpf_func, nome_func, email_func, endereco_func, "
					+ "telefone_func, senha_func) " + "VALUES( ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(queryhospede);

			ps.setInt(1, funcionario.getCpf());
			ps.setString(2, funcionario.getNome());
			ps.setString(3, funcionario.getEmail());
			ps.setString(4, funcionario.getEndereco());
			ps.setInt(5, funcionario.getTelefone());
			ps.setString(6, funcionario.getSenha());


			ps.executeQuery();
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public void Update(Funcionario funcionario) {
		Connection con = c.getConnection();
		String query = "UPDATE funcionario SET cpf_func = ?, nome_func = ?, email_func = ?, endereco_func = ?,"
				+ " telefone_func = ?, senha_func_func = ? WHERE cod_func = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, funcionario.getCpf());
			ps.setString(2, funcionario.getNome());
			ps.setString(3, funcionario.getEmail());
			ps.setString(4, funcionario.getEndereco());
			ps.setInt(5, funcionario.getTelefone());
			ps.setString(6, funcionario.getSenha());
			ps.setInt(7, funcionario.getCod());


			ps.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Delete(int cod) {
		Connection con = c.getConnection();
		String query = "UPDATE funcionario SET ativo = 0 WHERE cod_func = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, cod);
			ps.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	private Funcionario BancoEntity(ResultSet resultSet) throws SQLException {
		Funcionario funcionario = new Funcionario();
		funcionario.setCod((resultSet.getInt("cod_func")));
		funcionario.setCpf(resultSet.getInt("cpf_func"));
		funcionario.setNome(resultSet.getString("nome_func"));
		funcionario.setEmail(resultSet.getString("email_func"));
		funcionario.setEndereco(resultSet.getString("endereco_func"));
		funcionario.setTelefone(resultSet.getInt("telefone_func"));
		funcionario.setSenha(resultSet.getString("senha_func"));
		funcionario.setStatus(resultSet.getInt("status"));

		return funcionario;
	}
	
}
