package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Aluguel;
import entity.Funcionario;
import entity.Hospede;

public class AluguelDao {
	private ConexaoBanco c = new ConexaoBanco();	

	public List<Aluguel> Pesquisa() {
		List<Aluguel> Alugueis = new ArrayList<>();
		Connection con = c.getConnection();
		String queryPessoa = "SELECT * FROM funcionario;";
		try {
			PreparedStatement ps = con.prepareStatement(queryPessoa);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				Aluguel aluguel  = BancoEntity(resultSet);

				Alugueis.add(aluguel);
			}
			con.close();
			return Alugueis;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Aluguel PesquisaCod(int cod) {
		Aluguel aluguel = new Aluguel();
		Connection con = c.getConnection();
		String query = "SELECT * FROM aluguel WHERE cod_alug = ?;";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, cod);
			ResultSet resultSet = ps.executeQuery();


			aluguel = BancoEntity(resultSet);
			
			con.close();
			return aluguel;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void Insert(Aluguel aluguel) {
		try {

			Connection con = c.getConnection();
			String queryhospede = "Insert Into funcionario(cod_hosp, cod_func, Data_aluguel) "
					+ "VALUES( ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(queryhospede);

			ps.setInt(1, aluguel.getHospede().getCod());
			ps.setInt(2, aluguel.getFuncionario().getCod());
			ps.setDate(3, java.sql.Date.valueOf(aluguel.getData()));


			ps.executeQuery();
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public void Update(Aluguel aluguel) {
		Connection con = c.getConnection();
		String query = "UPDATE aluguel SET cod_hosp = ?, cod_func = ?, Data_aluguel = ? WHERE cod_alug = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, aluguel.getHospede().getCod());
			ps.setInt(2, aluguel.getFuncionario().getCod());
			ps.setDate(3, java.sql.Date.valueOf(aluguel.getData()));
			ps.setInt(1, aluguel.getCod());




			ps.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*public void Delete(int cod) {
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
	}*/


	private Aluguel BancoEntity(ResultSet resultSet) throws SQLException {
		Aluguel aluguel = new Aluguel();
		HospedeDao h = new HospedeDao();
		FuncionarioDao f = new FuncionarioDao();
		aluguel.setCod(resultSet.getInt("cod_alug"));
		aluguel.setHospede(h.PesquisaCod(resultSet.getInt("cod_hosp")));
		aluguel.setFuncionario(f.PesquisaCod(resultSet.getInt("cod_func")));
		aluguel.setData(resultSet.getDate("Data_aluguel").toLocalDate());
		

		return aluguel;
	}
}
