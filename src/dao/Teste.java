package dao;

import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.*;
//teste
public class Teste {
	public static void main(String[] args) {
		/*ConexaoBanco c = new ConexaoBanco();
		Connection con = c.getConnection();*/
		HospedeDao h = new HospedeDao();
		Hospede hospede = new Hospede ();
		CartaoDebito cartao = new CartaoDebito();
		CartaoDebitoDao c = new CartaoDebitoDao();
		List<Hospede> hospedes = new ArrayList<>();

		//funcionario.setCod("cod_func")));
		hospede.setCpf(311111122);
		hospede.setNome("teste2");
		hospede.setEmail("teste2");
		hospede.setEndereco("teste2");
		hospede.setTelefone(11111111);
		hospede.setSenha("teste");
		hospede.setStatus(1);
		//hospedes = h.Pesquisa()
		h.update(hospede);
		//h.Insert(hospede);
		//c.Insert(h.PesquisaCpf(hospede.getCpf()), cartao);
		/*Statement st = con.createStatement();
		String sql = "INSERT INTO hospede (cpf, nome, email, endereco, telefone, senha_hosp) "
				+ "VALUES ('2111111112', 'teste', 'teste', 'teste', '11111111', AES_ENCRYPT('teste', 'chave'))";
		int i = st.executeUpdate(sql);
		System.out.printf("Insert executado %d linhas foram afetadas%n", i);
		con.close();*/
		System.out.println("Conexão fechada");
	}
	
}
