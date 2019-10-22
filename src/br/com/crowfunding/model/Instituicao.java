package br.com.crowfunding.model;

public class Instituicao {

	private Integer id;
	private String nome;
	private String cnpj;
	private String telefone;
	private String email;
	private String responsavel;
	private String descricao;
	private String conta;
	private String agencia;
	private String senha;

	public Instituicao(String email, String senha) {
		
		this.email = email;
		this.senha = senha;
	}

	public Instituicao(String nome, String cnpj, String telefone, String email, String responsavel, String descricao,
			String conta, String agencia, String senha) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.email = email;
		this.responsavel = responsavel;
		this.descricao = descricao;
		this.conta = conta;
		this.agencia = agencia;
		this.senha = senha;
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

}
