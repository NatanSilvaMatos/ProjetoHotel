package entity;

public class Quarto {
	private int numero;
	private int andar;
	private Disponibilidade disponibilidade;
	private Categoria categoria;
	private double preco;
	
	Quarto(){
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getAndar() {
		return andar;
	}
	
	public void setAndar(int andar) {
		this.andar = andar;
	}
	
	public Disponibilidade getDisponibilidade() {
		return disponibilidade;
	}
	
	public void setDisponibilidade(Disponibilidade disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
}
