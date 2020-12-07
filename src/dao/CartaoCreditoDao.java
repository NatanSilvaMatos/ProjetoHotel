package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Cartao;
import entity.CartaoCredito;
import entity.CartaoDebito;
import entity.Hospede;

public class CartaoCreditoDao {
	private ConexaoBanco c = new ConexaoBanco();	

	public List<Cartao> Pesquisa() {
		List<Cartao> cartoes = new ArrayList<>();
		Connection con = c.getConnection();
		String querycartao = "SELECT * FROM funcionario;";
		try {
			PreparedStatement ps = con.prepareStatement(querycartao);
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
	
	
	public void Insert(Hospede hospede, CartaoCredito cartao) {
		try {

			Connection con = c.getConnection();
			String queryhospede = "Insert Into cartao(cod_hosp, nomero_cart, cvv, tipo) VALUES( ?, ?, ?, ?,)";
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

	public void Update(Hospede hospede, CartaoCredito cartao) {
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
		CartaoCredito cartao = new CartaoCredito();
		cartao.setCod_card((resultSet.getInt("cod_func")));
		cartao.setNumero(resultSet.getInt("cpf"));
		cartao.setCvv(resultSet.getInt("cvv"));
		cartao.setStatus(resultSet.getInt("status"));		

		return cartao;
	}
}
