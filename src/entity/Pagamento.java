package entity;

public class Pagamento {
	private Hospede hospede;
	private Aluguel aluguel;

	public Pagamento(Hospede hospede, Aluguel aluguel) {
		this.hospede = hospede;
		this.aluguel = aluguel;
	}	

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}
	
}
