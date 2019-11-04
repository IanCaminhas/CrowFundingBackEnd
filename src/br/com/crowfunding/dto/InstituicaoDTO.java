package br.com.crowfunding.dto;

public class InstituicaoDTO {

	private String nome;
	private String cnpj;
	private String telefone;
	private String email;
	private String responsavel;
	private String descricao;
	private String conta;
	private String agencia;
	private String senha;
	private String rua;
	private String bairro;
	private Integer numeroPropriedade;
	private String complemento;
	private String logradouro;

	public InstituicaoDTO(String nome, String cnpj, String telefone, String email, String responsavel, String descricao,
			String conta, String agencia, String senha, String rua, String bairro, Integer numeroPropriedade,
			String complemento, String logradouro) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.email = email;
		this.responsavel = responsavel;
		this.descricao = descricao;
		this.conta = conta;
		this.agencia = agencia;
		this.senha = senha;
		this.rua = rua;
		this.bairro = bairro;
		this.numeroPropriedade = numeroPropriedade;
		this.complemento = complemento;
		this.logradouro = logradouro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

}
