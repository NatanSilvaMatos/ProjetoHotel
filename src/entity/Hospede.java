package entity;

public class Hospede extends Pessoa {
	private Cartao cartao[];

	public Hospede() {

	}

	public Hospede(int cpf, String email, String nome, String endereco, int telefone, String senha, int status) {
		this.setCpf(cpf);
		this.setEmail(email);
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
		this.setSenha(senha);
		this.setStatus(status);
	}

	public Cartao[] getCartao() {
		return cartao;
	}

	public void setCartao(Cartao[] cartao) {
		this.cartao = cartao;
	}
}
