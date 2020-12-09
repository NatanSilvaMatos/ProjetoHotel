package entity;

public class CartaoDebito extends Cartao {

	public CartaoDebito() {

	}

	public CartaoDebito(int cod_card, int numero, int cvv, int status) {
		this.setCod_card(cod_card);
		this.setNumero(numero);
		this.setCvv(cvv);
		this.setStatus(status);

	}

	public String getTipo() {
		return "Debito";
	}

}
