package entity;

public class Funcionario extends Pessoa {

	public Funcionario() {

	}

	public Funcionario(long cpf, String email, String nome, String endereco, int telefone, String senha, int status) {
		this.setCpf(cpf);
		this.setEmail(email);
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
		this.setSenha(senha);
		this.setStatus(status);
	}

}
