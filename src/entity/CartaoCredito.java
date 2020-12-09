package entity;

public class CartaoCredito extends Cartao {

	public CartaoCredito() {

	}

	public CartaoCredito(int cod_card, int numero, int cvv, int status) {
		this.setCod_card(cod_card);
		this.setNumero(numero);
		this.setCvv(cvv);
		this.setStatus(status);
	}

	public String getTipo() {
		return "Credito";
	}

}
