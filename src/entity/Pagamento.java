package entity;

public class Pagamento {
	private int cod;
	private Quarto quarto;
	private Aluguel aluguel;
	private int numDias;

	public Pagamento() {

	}

	public Pagamento(Quarto quarto, Aluguel aluguel, int numDias) {
		this.quarto = quarto;
		this.aluguel = aluguel;
		this.numDias = numDias;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public int getNumDias() {
		return numDias;
	}

	public void setNumDias(int numDias) {
		this.numDias = numDias;
	}

}
