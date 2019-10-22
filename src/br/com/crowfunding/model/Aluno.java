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
	private String rua;
	private String bairro;
	private Integer numeroPropriedade;
	private String complemento;
	private String logradouro;


	public Aluno(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	
	public Aluno(Integer id, String nome, String telefone, String email, String dataNascimento, String cpf,
			String descricaoPerfil, Double rendaPerCapita, String senha, String rua, String bairro, Integer numero,
			String complemento, String logradouro) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.descricaoPerfil = descricaoPerfil;
		this.rendaPerCapita = rendaPerCapita;
		this.senha = senha;
		this.rua = rua;
		this.bairro = bairro;
		this.numeroPropriedade = numero;
		this.complemento = complemento;
		this.logradouro = logradouro;
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


	public Integer getNumero() {
		return numeroPropriedade;
	}


	public void setNumero(Integer numero) {
		this.numeroPropriedade = numero;
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
