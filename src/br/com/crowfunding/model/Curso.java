package br.com.crowfunding.model;

public class Curso {

	private Integer id;
	private String nome;
	private Double valor;
	private String ementa;
	
	public Curso(Integer id, String nome, Double valor, String ementa) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.ementa = ementa;
	}
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
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getEmenta() {
		return ementa;
	}
	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
	
	
	
	
	
	
	
}
