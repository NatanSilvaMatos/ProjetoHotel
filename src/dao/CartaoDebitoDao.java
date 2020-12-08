package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Cartao;
import entity.CartaoDebito;
import entity.Hospede;

public class CartaoDebitoDao {
	private ConexaoBanco c = new ConexaoBanco();

	public List<Cartao> Pesquisa(Hospede hospede) {
		List<Cartao> cartoes = new ArrayList<>();
		Connection con = c.getConnection();
		String querycartao = "SELECT c.cod_cart, c.numero_cart, c.cvv, c.tipo, c.status from cartao c "
				+ "INNER JOIN hospede h on c.cod_hosp = h.cod_hosp WHERE c.cod_hosp = ?;";
		try {
			PreparedStatement ps = con.prepareStatement(querycartao);
			ps.setInt(1, hospede.getCod());
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				Cartao cartao = BancoEntity(resultSet);

				cartoes.add(cartao);
			}
			con.close();
			return cartoes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void Insert(Hospede hospede, CartaoDebito cartao) {
		try {

			Connection con = c.getConnection();
			String queryhospede = "Insert Into cartao(cod_hosp, numero_cart, cvv, tipo) VALUES( ?, ?, ?, ?);";
			PreparedStatement ps = con.prepareStatement(queryhospede);
			ps.setInt(1, hospede.getCod());
			ps.setInt(2, cartao.getNumero());
			ps.setInt(3, cartao.getCvv());
			ps.setString(4, cartao.getTipo());

			ps.executeQuery();
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public void Update(Hospede hospede, CartaoDebito cartao) {
		Connection con = c.getConnection();
		String query = "UPDATE cartao SET cod_hosp = ?, nomero_cart = ?, cvv = ?, tipo = ? WHERE cod_cart = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, hospede.getCod());
			ps.setInt(2, cartao.getNumero());
			ps.setInt(3, cartao.getCvv());
			ps.setString(4, cartao.getTipo());
			ps.setInt(5, cartao.getCod_card());

			ps.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Delete(int cod) {
		Connection con = c.getConnection();
		String query = "UPDATE cartao SET ativo = 0 WHERE cod_cart = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, cod);
			ps.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private Cartao BancoEntity(ResultSet resultSet) throws SQLException {
		CartaoDebito cartao = new CartaoDebito();
		if (resultSet.next()) {
			cartao.setCod_card((resultSet.getInt(1)));
			cartao.setNumero(resultSet.getInt(2));
			cartao.setCvv(resultSet.getInt(3));
			cartao.setStatus(resultSet.getInt(4));
		}

		return cartao;
	}
}
