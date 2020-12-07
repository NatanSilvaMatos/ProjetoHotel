package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Categoria;
import entity.Disponibilidade;
import entity.Funcionario;
import entity.Quarto;

public class QuartoDao {
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
