package br.com.crowfunding.model;

import java.util.ArrayList;

public class Curso {

	private Integer id;
	private String nome;
	private Double valor;
	private String ementa;
	private Integer idInstituicao;
	private ArrayList<Integer> turmas = new ArrayList<Integer>();

	public Curso(String nome, Double valor, String ementa, Integer idInstituicao) {
		this.nome = nome;
		this.valor = valor;
		this.ementa = ementa;
		this.idInstituicao = idInstituicao;

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

	public Integer getIdInstituicao() {
		return idInstituicao;
	}

	public void setIdInstituicao(Integer idInstituicao) {
		this.idInstituicao = idInstituicao;
	}

	public ArrayList<Integer> getTurmas() {
		return turmas;
	}

}
