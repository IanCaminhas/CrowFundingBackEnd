package br.com.crowfunding.model;

public class Aluno {
	
	private Integer id;
	private String nome;
	private String telefone;
	private String email;
	//private Date dataNascimento;
	private String cpf;
	private String descricaoPerfil;
	private Double rendaPercapita;
	private String senha;


	public Aluno(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	public Aluno(String nome, String telefone, String email, String cpf,
			String descricaoPerfil, Double rendaPercapita, String senha) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
		this.descricaoPerfil = descricaoPerfil;
		this.rendaPercapita = rendaPercapita;
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
		return rendaPercapita;
	}
	
	public void setRendaPercapita(Double rendaPercapita) {
		this.rendaPercapita = rendaPercapita;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
}
