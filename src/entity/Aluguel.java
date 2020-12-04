package entity;

public class Aluguel {
	private Hospede hospede;
	private Quarto quartos[];
	
	Aluguel(){
	}
	
	public Hospede getHospede() {
		return hospede;
	}
	
	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}
}
