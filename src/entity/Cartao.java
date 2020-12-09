package entity;

import java.util.Date;

public abstract class Cartao {
	private int cod_card;
	private int numero;
	private int cvv;
	private int status;
	private String tipo;

	public Cartao() {
	}

	public int getCod_card() {
		return cod_card;
	}

	public void setCod_card(int cod_card) {
		this.cod_card = cod_card;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public abstract String getTipo();

}
