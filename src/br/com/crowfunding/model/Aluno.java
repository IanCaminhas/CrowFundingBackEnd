package br.com.crowfunding.model;

public class Aluno {

	private Integer id;
	private String nome;
	private String telefone;
	private String email;
	private String dataNascimento;
	private String cpf;
	private String descricaoPerfil;
	private Double rendaPerCapita;
	private String senha;
	private Integer idEndereco;
	

	public Aluno(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
	
	public Integer getIdEndereco() {
		return idEndereco;
	}
	
	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}
	
	public Aluno(String nome, String telefone, String email, String cpf,
			String descricaoPerfil, Double rendaPerCapita, String senha,Integer idEndereco, String dataNascimento) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
		this.descricaoPerfil = descricaoPerfil;
		this.rendaPerCapita = rendaPerCapita;
		this.senha = senha;
		this.idEndereco=idEndereco;
		this.dataNascimento = dataNascimento;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDescricaoPerfil() {
		return descricaoPerfil;
	}

	public void setDescricaoPerfil(String descricaoPerfil) {
		this.descricaoPerfil = descricaoPerfil;
	}

	public Double getRendaPercapita() {
		return rendaPerCapita;
	}

	public void setRendaPercapita(Double rendaPercapita) {
		this.rendaPerCapita = rendaPercapita;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public Double getRendaPerCapita() {
		return rendaPerCapita;
	}


	public void setRendaPerCapita(Double rendaPerCapita) {
		this.rendaPerCapita = rendaPerCapita;
	}


	

}
