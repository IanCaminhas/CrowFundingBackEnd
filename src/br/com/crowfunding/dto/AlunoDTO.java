package br.com.crowfunding.dto;

public class AlunoDTO {

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

	public AlunoDTO(String nome, String telefone, String email, String dataNascimento, String cpf,
			String descricaoPerfil, Double rendaPerCapita, String senha, String rua, String bairro,
			Integer numeroPropriedade, String complemento, String logradouro) {
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public Double getRendaPerCapita() {
		return rendaPerCapita;
	}

	public void setRendaPerCapita(Double rendaPerCapita) {
		this.rendaPerCapita = rendaPerCapita;
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
