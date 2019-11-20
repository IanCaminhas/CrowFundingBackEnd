package br.com.crowfunding.dto;

public class DoacaoDTO {

	private Double valor;
	private String dataDoacao;
	private Integer idTurma;
	private Integer idAluno;
	private String nomeDoador;
	private String nome;
	private String agencia;
	private String conta;

	public DoacaoDTO(Double valor, String dataDoacao, Integer idTurma, Integer idAluno, String nomeDoador, String nome,
			String agencia, String conta) {

		this.valor = valor;
		this.dataDoacao = dataDoacao;
		this.idTurma = idTurma;
		this.idAluno = idAluno;
		this.nomeDoador = nomeDoador;
		this.nome = nome;
		this.agencia = agencia;
		this.conta = conta;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDataDoacao() {
		return dataDoacao;
	}

	public void setDataDoacao(String dataDoacao) {
		this.dataDoacao = dataDoacao;
	}

	public Integer getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}

	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public String getNomeDoador() {
		return nomeDoador;
	}

	public void setNomeDoador(String nomeDoador) {
		this.nomeDoador = nomeDoador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

}
