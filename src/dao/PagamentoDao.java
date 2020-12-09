package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Aluguel;
import entity.Pagamento;

public class PagamentoDao {
	private ConexaoBanco c = new ConexaoBanco();

	public List<Pagamento> Pesquisa() {
		List<Pagamento> pagamentos = new ArrayList<>();
		Connection con = c.getConnection();
		String query = "SELECT * FROM pagamento;";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				Pagamento pagamento = BancoEntity(resultSet);

				pagamentos.add(pagamento);
			}
			con.close();
			return pagamentos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Pagamento PesquisaCod(int cod) {
		Pagamento pagamento = new Pagamento();
		Connection con = c.getConnection();
		String query = "SELECT * FROM pagamento WHERE cod_pag = ?;";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, cod);
			ResultSet resultSet = ps.executeQuery();

			pagamento = BancoEntity(resultSet);

			con.close();
			return pagamento;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Pagamento> Pesquisahospede(int cpf) {
		List<Pagamento> pagamentos = new ArrayList<>();
		Connection con = c.getConnection();
		String query = "SELECT p.cod_pag, p.numero_quar, p.cod_alug, p.num_Dias FROM pagamento p INNER JOIN"
				+ "	aluguel a on p.cod_alug = a.cod_alug where a.cod_hosp = (SELECT cod_hosp FROM hospede where cpf = ?);";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, cpf);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				Pagamento pagamento = BancoEntity(resultSet);

				pagamentos.add(pagamento);
			}
			con.close();
			return pagamentos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void Insert(Pagamento pagamento) {
		try {

			Connection con = c.getConnection();
			String query = "Insert Into pagamento (numero_quar, cod_alug, num_Dias) " + "VALUES( ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, pagamento.getQuarto().getNumero());
			ps.setInt(2, pagamento.getAluguel().getCod());
			ps.setInt(3, pagamento.getNumDias());

			ps.executeQuery();
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public void Update(Pagamento pagamento) {
		Connection con = c.getConnection();
		String query = "UPDATE pagamento SET numero_quar = ?, cod_alug = ?, num_Dias = ? WHERE cod_pag = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, pagamento.getQuarto().getNumero());
			ps.setInt(2, pagamento.getAluguel().getCod());
			ps.setInt(3, pagamento.getNumDias());
			ps.setInt(1, pagamento.getCod());

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
	 * }-
	 */

	private Pagamento BancoEntity(ResultSet resultSet) throws SQLException {
		Pagamento pagamento = new Pagamento();
		QuartoDao q = new QuartoDao();
		AluguelDao a = new AluguelDao();
		if (resultSet.next()) {
			pagamento.setCod(resultSet.getInt(1));
			pagamento.setQuarto(q.PesquisaNumQuarto(resultSet.getInt(2)));
			pagamento.setAluguel(a.PesquisaCod(resultSet.getInt(3)));
			pagamento.setNumDias(resultSet.getInt(4));
		}
		
		/*pagamento.setCod(resultSet.getInt("cod_pag"));
		pagamento.setQuarto(q.PesquisaNumQuarto(resultSet.getInt(""numero_quar)));
		pagamento.setAluguel(a.PesquisaCod(resultSet.getInt("cod_alug")));
		pagamento.setNumDias(resultSet.getInt("num_Dias"));*/

		return pagamento;
	}
}
