package entity;

public class Hospede extends Pessoa {
	private Cartao cartao[];

	public Hospede() {
	}

	public Cartao[] getCartao() {
		return cartao;
	}

	public void setCartao(Cartao[] cartao) {
		this.cartao = cartao;
	}
}
