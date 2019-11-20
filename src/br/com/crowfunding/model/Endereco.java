package br.com.crowfunding.model;

public class Endereco {

	private Integer id;
	private String rua;
	private String bairro;
	private Integer numeroPropriedade;
	private String complemento;
	private String logradouro;

	public Endereco(String rua, String bairro, Integer numeroPropriedade, String complemento, String logradouro) {
		this.rua = rua;
		this.bairro = bairro;
		this.numeroPropriedade = numeroPropriedade;
		this.complemento = complemento;
		this.logradouro = logradouro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getNumeroPropriedade() {
		return numeroPropriedade;
	}

	public void setNumeroPropriedade(Integer numeroPropriedade) {
		this.numeroPropriedade = numeroPropriedade;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	@Override
	public String toString() {
		return "rua:" + rua + ", bairro:" + bairro + ", numeroPropriedade:" + numeroPropriedade + ", complemento:"
				+ complemento + ", logradouro:" + logradouro + "";
	}

}
