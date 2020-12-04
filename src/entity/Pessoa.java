package entity;

public class Pessoa {
	private int cpf;
	private String email;
	private String nome;
	private String endereco;
	private int telefone;
	private int rg;
	private Cartao cartoes[];
	
	Pessoa(){
	}
	
	Pessoa(int cpf, String email, String nome, String endereco, int telefone, int rg, Cartao cartoes[]){
		this.cpf = cpf;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.rg = rg;
		this.cartoes = cartoes;
	}
	
	public int getCpf() {
		return cpf;
	}
	
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public int getTelefone() {
		return telefone;
	}
	
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	public int getRg() {
		return rg;
	}
	
	public void setRg(int rg) {
		this.rg = rg;
	}
	
	public Cartao[] getCartoes() {
		return cartoes;
	}
	
	public void setCartoes(Cartao[] cartoes) {
		this.cartoes = cartoes;
	}
	
}
