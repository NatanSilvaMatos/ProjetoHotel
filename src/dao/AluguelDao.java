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
		String query = "SELECT * FROM aluguel;";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				Aluguel aluguel = BancoEntity(resultSet);

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
	
	public List<Aluguel> PesquisaCpf(long cpf) {
		List<Aluguel> Alugueis = new ArrayList<>();
		Connection con = c.getConnection();
		String query = "SELECT a.cod_alug, a.cod_hosp, a.cod_func, a.Data_aluguel FROM aluguel p INNER JOIN "
				+ "hospede h on a.cod_hosp = h.cod_hosp where h.cod_hosp = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, cpf);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				Aluguel aluguel = BancoEntity(resultSet);

				Alugueis.add(aluguel);
			}
			con.close();
			return Alugueis;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	

	public void Insert(Aluguel aluguel) {
		try {

			Connection con = c.getConnection();
			String queryhospede = "Insert Into aluguel(cod_hosp, cod_func, Data_aluguel) VALUES( ?, ?)";
			PreparedStatement ps = con.prepareStatement(queryhospede);

			ps.setInt(1, aluguel.getHospede().getCod());
			ps.setInt(2, aluguel.getFuncionario().getCod());

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
			ps.setLong(1, aluguel.getHospede().getCod());
			ps.setLong(2, aluguel.getFuncionario().getCod());
			ps.setDate(3, java.sql.Date.valueOf(aluguel.getData()));
			ps.setInt(1, aluguel.getCod());

			ps.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public void Delete(int cod) { Connection con = c.getConnection(); String
	 * query = "UPDATE funcionario SET ativo = 0 WHERE cod_func = ?"; try {
	 * PreparedStatement ps = con.prepareStatement(query); ps.setInt(1, cod);
	 * ps.execute(); con.close(); } catch (SQLException e) { e.printStackTrace(); }
	 * }
	 */

	private Aluguel BancoEntity(ResultSet resultSet) throws SQLException {
		Aluguel aluguel = new Aluguel();
		HospedeDao h = new HospedeDao();
		FuncionarioDao f = new FuncionarioDao();

		if (resultSet.next()) {
			aluguel.setCod(resultSet.getInt(1));
			aluguel.setHospede(h.PesquisaCod(resultSet.getInt(2)));
			aluguel.setFuncionario(f.PesquisaCod(resultSet.getInt(3)));
			aluguel.setData(resultSet.getDate(4).toLocalDate());
			
			//aluguel.setCod(resultSet.getInt("cod_alug"));
			//aluguel.setHospede(h.PesquisaCod(resultSet.getInt("cod_hosp")));
			//aluguel.setFuncionario(f.PesquisaCod(resultSet.getInt("cod_func")));
			//aluguel.setData(resultSet.getDate("Data_aluguel").toLocalDate());
		}else {
			aluguel=null;
		}

		return aluguel;
	}
}
