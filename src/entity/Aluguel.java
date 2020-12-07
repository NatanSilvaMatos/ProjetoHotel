package entity;

public class Aluguel {
	private Hospede hospede;
	private Quarto quartos[];

	public Aluguel(Quarto quartos[], Hospede hospede) {
		this.quartos = quartos;
		this.hospede = hospede;

	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}
}
