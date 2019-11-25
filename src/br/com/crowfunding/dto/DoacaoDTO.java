package br.com.crowfunding.dto;

public class DoacaoDTO {

	private Double valor;
	private Integer idTurma;
	private Integer idAluno;
	private String nomeDoador;
	private String agencia;
	private String conta;
	private String dataDoacao;

	public DoacaoDTO(Double valor, Integer idTurma, Integer idAluno, String nomeDoador,
			String agencia, String conta,String dataDoacao) {

		this.valor = valor;
		this.idTurma = idTurma;
		this.idAluno = idAluno;
		this.nomeDoador = nomeDoador;
		this.agencia = agencia;
		this.conta = conta;
		this.dataDoacao=dataDoacao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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
	
	public String getDataDoacao() {
		return dataDoacao;
	}
	
	public void setDataDoacao(String dataDoacao) {
		this.dataDoacao = dataDoacao;
	}

}
