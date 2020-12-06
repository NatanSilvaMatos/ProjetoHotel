package dao;
import java.sql.*;
import java.util.Optional;

import entity.Hospede;;
public class HospedeDao {
	
	//public Optional<Hospede> get(int id) {
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

    /*@Override
    public List<Hospede> getAll() {
        List<Hospede> hospede = new ArrayList<>();
        String queryPessoa = "SELECT * FROM funcionario f INNER JOIN pessoa_fisica pf on f.id_pessoa_fisica = pf.id_pessoa_fisica";
        try {
        	Connection con = ConnectionSingleton.instancia().connection();
			String sql = "SELECT * FROM contato WHERE nome like ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + nome + "%");
			ResultSet rs = st.executeQuery();
			while (rs.next()) { 
				Contato c = new Contato();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setTelefone(rs.getString("telefone"));
				c.setEmail(rs.getString("email"));
				c.setNascimento(rs.getDate("nascimento").toLocalDate());
				lista.add(c);
			}
            }
            con.close();
            return funcionarios;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/

    
    public void save(Hospede hospede) {
        try {
        	
        	Connection con = c.getConnection();
            String queryhospede = "Insert Into hospede(cpf, nome, email, endereco, telefone, senha_hosp) "
            		+ "VALUES( ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstm = con.prepareStatement(queryhospede);

            pstm.setInt(1, hospede.getCpf());
            pstm.setString(2, hospede.getNome());
            pstm.setString(3, hospede.getEmail());
            pstm.setString(4, hospede.getEndereco());
            pstm.setInt(5, hospede.getTelefone());
            pstm.setString(6, hospede.getSenha());   
            //pstm.setString(14, funcionario.getLogin());
            //pstm.setString(15, funcionario.getSenha());

            pstm.executeQuery();
			con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    
    public void update(Hospede hospede) {
        Connection con = c.getConnection();
        String query = "UPDATE hospede SET cpf = ?, nome = ?, email = ?, endereco = ?, telefone = ?, senha_hosp = ?"
        		+ " WHERE cod_hosp = ?";
       // String query = "call sp_atualizarFuncionario(?, ? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, hospede.getCod());
            pstm.setInt(2, hospede.getCpf());
            pstm.setString(3, hospede.getNome());
            pstm.setString(4, hospede.getEmail());
            pstm.setString(5, hospede.getEndereco());
            pstm.setInt(6, hospede.getTelefone());
            pstm.setString(7, hospede.getSenha());   



            pstm.execute();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public void delete(int cod) {
        Connection con = c.getConnection();
        String query = "UPDATE hospede SET ativo = 0 WHERE cod_hosp = ?";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1, cod);
            pstm.execute();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


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
