package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Funcionario;

public class FuncionarioDao {
	private ConexaoBanco c = new ConexaoBanco();
	/*Funcionario funcionario = new Funcionario();
    try {
        String query = "CALL sp_getFuncionario (?)";
        PreparedStatement pstm = connection.prepareStatement(query);
        pstm.setLong(1, id);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            funcionario = daoToEntity(resultSet);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return Optional.of(funcionario);
}*/


	/*public List<Funcionario> select() {
    List<Funcionario> funcionarios = new ArrayList<>();
	Connection con = c.getConnection();
    String queryPessoa = "SELECT * FROM funcionario f INNER JOIN pessoa_fisica pf on f.id_pessoa_fisica = pf.id_pessoa_fisica";
    try {
        PreparedStatement pstm = con.prepareStatement(queryPessoa);
        ResultSet resultSet = pstm.executeQuery();

        while (resultSet.next()) {

            Funcionario funcionario = daoToEntity(resultSet);

            funcionarios.add(funcionario);
        }
        con.close();
        return funcionarios;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}*/


public void save(Funcionario funcionario) {
    try {
    	
    	Connection con = c.getConnection();
        String queryhospede = "Insert Into hospede(cpf_func, nome_func, email_func, endereco_func, "
        		+ "telefone_func, senha_func) "
        		+ "VALUES( ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = con.prepareStatement(queryhospede);

        pstm.setInt(1, funcionario.getCpf());
        pstm.setString(2, funcionario.getNome());
        pstm.setString(3, funcionario.getEmail());
        pstm.setString(4, funcionario.getEndereco());
        pstm.setInt(5, funcionario.getTelefone());
        pstm.setString(6, funcionario.getSenha());   
        //pstm.setString(14, funcionario.getLogin());
        //pstm.setString(15, funcionario.getSenha());

        pstm.executeQuery();
		con.close();
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
}


public void update(Funcionario funcionario) {
    Connection con = c.getConnection();
    String query = "UPDATE funcionario SET cpf_func = ?, nome_func = ?, email_func = ?, endereco_func = ?,"
    		+ " telefone_func = ?, senha_func_func = ? WHERE cod_func = ?";
   // String query = "call sp_atualizarFuncionario(?, ? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?)";
    try {
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1, funcionario.getCod());
        pstm.setInt(2, funcionario.getCpf());
        pstm.setString(3, funcionario.getNome());
        pstm.setString(4, funcionario.getEmail());
        pstm.setString(5, funcionario.getEndereco());
        pstm.setInt(6, funcionario.getTelefone());
        pstm.setString(7, funcionario.getSenha());   



        pstm.execute();
        con.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


public void delete(int cod) {
    Connection con = c.getConnection();
    String query = "UPDATE funcionario SET ativo = 0 WHERE cod_func = ?";
    try {
        PreparedStatement pstm = con.prepareStatement(query);
        pstm.setInt(1, cod);
        pstm.execute();
        con.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

//
/*private Funcionario daoToEntity(ResultSet resultSet) throws SQLException {
    Funcionario funcionario = new Funcionario();
    funcionario.setRegistroFuncionario(resultSet.getInt("id_funcionario"));
    funcionario.setDataNasc(resultSet.getObject("admissao", LocalDate.class));
    funcionario.setDataNasc(resultSet.getObject("demissao", LocalDate.class));
    funcionario.setLogin(resultSet.getString("login"));
    funcionario.setSenha(resultSet.getString("senha"));

    //Atributos Pessoa Fisica
    funcionario.setRegistroFuncionario(resultSet.getInt("id_pessoa_fisica"));
    funcionario.setAtivo(resultSet.getBoolean("ativo"));
    funcionario.setNome(resultSet.getString("nome"));
    funcionario.setCpf(resultSet.getString("cpf").substring(0, 3) +
            "." + resultSet.getString("cpf").substring(3, 6) +
            "." + resultSet.getString("cpf").substring(6, 9) +
            "-" + resultSet.getString("cpf").substring(9, 11));
    funcionario.setDataNasc(resultSet.getObject("nascimento", LocalDate.class));
    funcionario.setLogradouro(resultSet.getString("logradouro"));
    funcionario.setNumero(resultSet.getString("numero"));
    funcionario.setComplemento(resultSet.getString("complemento"));
    funcionario.setBairro(resultSet.getString("bairro"));
    funcionario.setCidade(resultSet.getString("cidade"));
    funcionario.setUf(resultSet.getString("uf"));
    try {
        funcionario.setCep(resultSet.getString("cep").substring(0, 5) +
                "-" + resultSet.getString("cep").substring(5, 8));
    } catch (Exception throwables) {
        System.out.println("Funcionario " + funcionario.getRegistroFuncionario() + " sem endereço cadastrado");
    }
    funcionario.setTelefones(telefoneDAO.getAllByIdPessoaFisica(funcionario.getRegistroFuncionario()));
    funcionario.setEmails(emailDAO.getAllByIdPessoaFisica(funcionario.getRegistroFuncionario()));

    return funcionario;
}

@Override
public boolean logar(String login, String senha) throws SQLException {

    try {
        String query = "CALL sp_logar (?,?)";
        PreparedStatement pstm = connection.prepareStatement(query);
        pstm.setString(1, login);
        pstm.setString(2, senha);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            Funcionario logado = daoToEntity(resultSet);
            return true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}*/
}
