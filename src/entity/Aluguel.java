package entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Aluguel {
	private int cod;
	private Hospede hospede;
	private Funcionario funcionario;
	private LocalDate data;
	private List<Quarto> quarto;

	public Aluguel() {
	}

	public Aluguel(Hospede hospede, Funcionario funcionario, LocalDate data, List<Quarto> quarto) {
		this.hospede = hospede;
		this.funcionario = funcionario;
		this.data = data;
		this.quarto = quarto;
	}

	public List<Quarto> getQuarto() {
		return quarto;
	}

	public void setQuarto(List<Quarto> quarto) {
		this.quarto = quarto;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public Hospede getHospede() {
		return hospede;
	}

	public void setHospede(Hospede hospede) {
		this.hospede = hospede;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

}
