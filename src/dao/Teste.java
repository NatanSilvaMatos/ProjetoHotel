package dao;

import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.*;

//teste
public class Teste {
	public static void main(String[] args) {
		/*
		 * ConexaoBanco c = new ConexaoBanco(); Connection con = c.getConnection();
		 */
		FuncionarioDao h = new FuncionarioDao();
		Funcionario funcionario = new Funcionario();
		CartaoDebito cartao = new CartaoDebito();
		CartaoDebitoDao c = new CartaoDebitoDao();
		List<Hospede> hospedes = new ArrayList<>();
		QuartoDao quarto = new QuartoDao();
		
		for(Quarto s: quarto.Pesquisa()) {
			System.out.println(s);
		}
		
		

		// funcionario.setCod("cod_func")));
		// hospede.setCod(6);
		/*funcionario.setCpf(411111124);
		funcionario.setNome("teste4");
		funcionario.setEmail("teste4");
		funcionario.setEndereco("teste4");
		funcionario.setTelefone(11111111);
		funcionario.setSenha("teste");
		funcionario.setStatus(1);
		h.Insert(funcionario);
		//LoginDao l = new LoginDao();
		//System.out.println(l.LoginHospede(411111124, "teste3"));
		// System.out.println(hospedes.);
		// h.update(hospede);
		// h.Insert(hospede);
		/*
		 * cartao.setNumero(12345); cartao.setCvv(123); cartao.setStatus(1);
		 * c.Insert(h.PesquisaCpf(hospede.getCpf()), cartao); /*Statement st =
		 * con.createStatement(); String sql =
		 * "INSERT INTO hospede (cpf, nome, email, endereco, telefone, senha_hosp) " +
		 * "VALUES ('2111111112', 'teste', 'teste', 'teste', '11111111', AES_ENCRYPT('teste', 'chave'))"
		 * ; int i = st.executeUpdate(sql);
		 * System.out.printf("Insert executado %d linhas foram afetadas%n", i);
		 * con.close(); Quarto quarto = new Quarto(); QuartoDao q = new QuartoDao();
		 * quarto.setNumero(2); quarto.setAndar(2);
		 * quarto.setDisponibilidade(Disponibilidade.DISPONIVEL);
		 * quarto.setCategoria(Categoria.COMUM); <<<<<<< HEAD quarto.setPreco(100.0);
		 * q.Insert(quarto);
		 */
		// Pagamento pag = new Pagamento();
		// PagamentoDao p = new PagamentoDao();
		// pag.setAluguel(aluguel);
		Aluguel aluguel = new Aluguel();
		AluguelDao a= new AluguelDao();
		System.out.println(a.PesquisaCod(1).getFuncionario().getNome());


	}
}
