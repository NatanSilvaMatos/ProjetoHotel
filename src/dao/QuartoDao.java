package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Categoria;
import entity.Disponibilidade;
import entity.Quarto;

public class QuartoDao {
	private ConexaoBanco c = new ConexaoBanco();	

	public List<Quarto> Pesquisa() {
		List<Quarto> quartos = new ArrayList<>();
		Connection con = c.getConnection();
		String query = "SELECT * FROM quarto;";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				Quarto quarto = BancoEntity(resultSet);

				quartos.add(quarto);
			}
			con.close();
			return quartos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Quarto PesquisaNumQuarto(int num) {
		Quarto quarto = new Quarto();
		Connection con = c.getConnection();
		String query = "SELECT * FROM quarto WHERE numero_quar = ?;";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, num);
			ResultSet resultSet = ps.executeQuery();


				quarto = BancoEntity(resultSet);
			
			con.close();
			return quarto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Quarto PesquisaQuartoDisp() {
		Quarto quarto = new Quarto();
		Connection con = c.getConnection();
		String query = "SELECT * FROM quarto WHERE disponibilidade = 1;";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet resultSet = ps.executeQuery();


				quarto = BancoEntity(resultSet);
			
			con.close();
			return quarto;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void Insert(Quarto quarto) {
		try {

			Connection con = c.getConnection();
			String queryhospede = "Insert Into quarto(numero_quar, andar, disponibilidade, categoria, preco) "
					 + "VALUES( ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(queryhospede);
			ps.setInt(1, quarto.getNumero());
			ps.setInt(2, quarto.getAndar());
			if(quarto.getDisponibilidade()==Disponibilidade.DISPONIVEL) {
				ps.setInt(3, 1);
			}else if(quarto.getDisponibilidade()==Disponibilidade.LOCADO) {
				ps.setInt(3, 2);
			}		
			if(quarto.getCategoria()==Categoria.COMUM) {
				ps.setInt(4, 1);
			}else if(quarto.getCategoria()==Categoria.PREMIUM) {
				ps.setInt(4, 2);
			}else if(quarto.getCategoria()==Categoria.PRESIDENCIAL) {
				ps.setInt(4, 3);
			}
			ps.setDouble(5, quarto.getPreco());


			ps.executeQuery();
			con.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}

	public void Update(Quarto quarto) {
		Connection con = c.getConnection();
		String query = "UPDATE funcionario SET andar = ?, disponibilidade = ?, categoria = ?,"
				+ " preco = ?, status = ? WHERE numero_quar = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, quarto.getAndar());
			if(quarto.getDisponibilidade()==Disponibilidade.DISPONIVEL) {
				ps.setInt(2, 1);
			}else if(quarto.getDisponibilidade()==Disponibilidade.LOCADO) {
				ps.setInt(2, 2);
			}		
			if(quarto.getCategoria()==Categoria.COMUM) {
				ps.setInt(3, 1);
			}else if(quarto.getCategoria()==Categoria.PREMIUM) {
				ps.setInt(3, 2);
			}else if(quarto.getCategoria()==Categoria.PRESIDENCIAL) {
				ps.setInt(3, 3);
			}
			ps.setDouble(4, quarto.getPreco());
			ps.setInt(5, quarto.getStatus());
			ps.setInt(6, quarto.getNumero());
			
			ps.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Delete(int num) {
		Connection con = c.getConnection();
		String query = "UPDATE quarto SET status = 0 WHERE numero_quart = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, num);
			ps.execute();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	private Quarto BancoEntity(ResultSet resultSet) throws SQLException {
		Quarto quarto = new Quarto();
		quarto.setNumero((resultSet.getInt("numero_quar")));
		quarto.setAndar(resultSet.getInt("andar"));
		if(resultSet.getInt("disponibilidade")==1) {
			quarto.setDisponibilidade(Disponibilidade.DISPONIVEL);
		}else if(resultSet.getInt("disponibilidade")==2) {
			quarto.setDisponibilidade(Disponibilidade.LOCADO);
		}		
		if(resultSet.getInt("categoria")==1) {
			quarto.setCategoria(Categoria.COMUM);
		}else if(resultSet.getInt("categoria")==2) {
			quarto.setCategoria(Categoria.PREMIUM);
		}else if(resultSet.getInt("categoria")==3) {
			quarto.setCategoria(Categoria.PRESIDENCIAL);
		}
		quarto.setPreco(resultSet.getDouble("preco"));
		

		return quarto;
	}
}
