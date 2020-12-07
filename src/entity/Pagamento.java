package entity;

public class Pagamento {
	private Quarto quarto;
	private Aluguel aluguel;
	private int numDias;

	public Pagamento(Quarto quarto, Aluguel aluguel, int numDias) {
		this.quarto = quarto;
		this.aluguel = aluguel;
		this.numDias = numDias;
	}
	
	public Pagamento() {
		
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
