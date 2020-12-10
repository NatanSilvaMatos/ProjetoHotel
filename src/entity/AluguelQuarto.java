package entity;

public class AluguelQuarto {
	private int numQuarto;
	private int andarQuarto;
	private Categoria categoriaQuarto;
	private String dataAluguel;
	private double precoQuarto;
	private long cpfHospede;
	private String nomeHospede;
	
	public AluguelQuarto(int numQuarto, int andarQuarto, Categoria categoriaQuarto, String dataAluguel,
			double precoQuarto, long cpfHospede, String nomeHospede) {
		this.numQuarto = numQuarto;
		this.andarQuarto = andarQuarto;
		this.categoriaQuarto = categoriaQuarto;
		this.dataAluguel = dataAluguel;
		this.precoQuarto = precoQuarto;
		this.cpfHospede = cpfHospede;
		this.nomeHospede = nomeHospede;
	}

	public int getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(int numQuarto) {
		this.numQuarto = numQuarto;
	}

	public int getAndarQuarto() {
		return andarQuarto;
	}

	public void setAndarQuarto(int andarQuarto) {
		this.andarQuarto = andarQuarto;
	}

	public Categoria getCategoriaQuarto() {
		return categoriaQuarto;
	}

	public void setCategoriaQuarto(Categoria categoriaQuarto) {
		this.categoriaQuarto = categoriaQuarto;
	}

	public String getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(String dataAluguel) {
		this.dataAluguel = dataAluguel;
	}

	public double getPrecoQuarto() {
		return precoQuarto;
	}

	public void setPrecoQuarto(double precoQuarto) {
		this.precoQuarto = precoQuarto;
	}

	public long getCpfHospede() {
		return cpfHospede;
	}

	public void setCpfHospede(long cpfHospede) {
		this.cpfHospede = cpfHospede;
	}

	public String getNomeHospede() {
		return nomeHospede;
	}

	public void setNomeHospede(String nomeHospede) {
		this.nomeHospede = nomeHospede;
	}
	

}
