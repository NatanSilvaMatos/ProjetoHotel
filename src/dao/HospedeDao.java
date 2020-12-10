package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import entity.Hospede;;

public class HospedeDao {
	private ConexaoBanco c = new ConexaoBanco();

	public List<Hospede> Pesquisa() {
		List<Hospede> hospedes = new ArrayList<>();
		Connection con = c.getConnection();
		String queryPessoa = "SELECT * FROM hospede;";
		try {
			PreparedStatement pstm = con.prepareStatement(queryPessoa);
			ResultSet resultSet = pstm.executeQuery();

			while (resultSet.next()) {

				Hospede hospede = BancoEntity(resultSet);

				hospedes.add(hospede);
			}
			con.close();
			return hospedes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Hospede PesquisaCpf(int cpf) {
		Hospede hospede = new Hospede();
		Connection con = c.getConnection();
		String queryPessoa = "SELECT * FROM hospede WHERE cpf = ?;";
		try {
			PreparedStatement ps = con.prepareStatement(queryPessoa);
			ps.setInt(1, cpf);
			ResultSet resultSet = ps.executeQuery();
			
				hospede = BancoEntity(resultSet);			

			con.close();
			return hospede;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Hospede PesquisaCod(int cod) {
		Hospede hospede = new Hospede();
		Connection con = c.getConnection();
		String queryPessoa = "SELECT * FROM hospede WHERE cod_hosp = ?;";
		try {
			PreparedStatement ps = con.prepareStatement(queryPessoa);
			ps.setInt(1, cod);
			ResultSet resultSet = ps.executeQuery();
			hospede = BancoEntity(resultSet);

			con.close();
			return hospede;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void Insert(Hospede hospede) {
		try {

			Connection con = c.getConnection();
			String queryhospede = "Insert Into hospede(cpf, nome, email, endereco, telefone, senha_hosp) "
					+ "VALUES( ?, ?, ?, ?, ?, AES_ENCRYPT(?, 'chave'))";
			PreparedStatement ps = con.prepareStatement(queryhospede);

			ps.setInt(1, hospede.getCpf());
			ps.setString(2, hospede.getNome());
			ps.setString(3, hospede.getEmail());
			ps.setString(4, hospede.getEndereco());
			ps.setInt(5, hospede.getTelefone());
			ps.setString(6, hospede.getSenha());

			ps.executeQuery();
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public void update(Hospede hospede) {
		Connection con = c.getConnection();
		String query = "UPDATE hospede SET cpf = ?, nome = ?, email = ?, endereco = ?, telefone = ?, senha_hosp = AES_ENCRYPT(?, 'chave')"
				+ " WHERE cod_hosp = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, hospede.getCpf());
			ps.setString(2, hospede.getNome());
			ps.setString(3, hospede.getEmail());
			ps.setString(4, hospede.getEndereco());
			ps.setInt(5, hospede.getTelefone());
			ps.setString(6, hospede.getSenha());
			ps.setInt(7, hospede.getCod());

			ps.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int cod) {
		Connection con = c.getConnection();
		String query = "UPDATE hospede SET ativo = 0 WHERE cod_hosp = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, cod);
			ps.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Hospede BancoEntity(ResultSet resultSet) throws SQLException {
		Hospede hospede = new Hospede();
		if (resultSet.next()) {
			hospede.setCod(resultSet.getInt(1));
			hospede.setCpf(resultSet.getInt(2));
			hospede.setNome(resultSet.getString(3));
			hospede.setEmail(resultSet.getString(4));
			hospede.setEndereco(resultSet.getString(5));
			hospede.setTelefone(resultSet.getInt(6));
			hospede.setSenha(resultSet.getString(7));
			hospede.setStatus(resultSet.getInt(8));

			/*hospede.setCod(resultSet.getInt("cod_hosp"));
			hospede.setCpf(resultSet.getInt("cpf"));
			hospede.setNome(resultSet.getString("nome"));
			hospede.setEmail(resultSet.getString("email"));
			hospede.setEndereco(resultSet.getString("endereco"));
			hospede.setTelefone(resultSet.getInt("telefone"));
			hospede.setSenha(resultSet.getString("senha_hosp"));
			hospede.setStatus(resultSet.getInt("status"));*/

		}else {
			hospede = null;
		}

		//hospede.setCod(resultSet.getInt("cod_hosp"));
		//hospede.setCpf(resultSet.getInt("cpf"));
		//hospede.setNome(resultSet.getString("nome"));
		//hospede.setEmail(resultSet.getString("email"));
		//hospede.setEndereco(resultSet.getString("endereco"));
		//hospede.setTelefone(resultSet.getInt("telefone"));
		//hospede.setSenha(resultSet.getString("senha_hosp"));
		//hospede.setStatus(resultSet.getInt("status"));

		return hospede;
	}
}
