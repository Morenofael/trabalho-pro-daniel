package br.ifpr.modelo;

public class Pessoa {
	Integer id;
	String nome;
	String email;
	String telefone;
	Float altura;
	Float peso;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Float getAltura() {
		return altura;
	}
	public void setAltura(Float altura) {
		this.altura = altura;
	}
	public Float getPeso() {
		return peso;
	}
	public void setPeso(Float peso) {
		this.peso = peso;
	}
	public String retornaDadosPessoa() {
		String pes = "ID = " + id;
		pes += " | Nome = " + nome;
		pes += " | Email = " + email;
		pes += " | Telefone = " + telefone;
		pes += " | Altura = " + altura;
		pes += " | Peso = " + peso;
		
		return pes;
	}
}
