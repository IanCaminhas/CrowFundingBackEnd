package br.com.crowfunding.dto;

public class DadosParaDoacaoDTO {

	private String nomeAluno;
	private String nomeCurso;
	private Integer idAluno;
	private String nomeInstiuicao;
	private Integer idTurma;

	public DadosParaDoacaoDTO(String nomeAluno, String nomeCurso, Integer idAluno, String nomeInstiuicao,
			Integer idTurma) {

		this.nomeAluno = nomeAluno;
		this.nomeCurso = nomeCurso;
		this.idAluno = idAluno;
		this.nomeInstiuicao = nomeInstiuicao;
		this.idTurma = idTurma;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public String getNomeInstiuicao() {
		return nomeInstiuicao;
	}

	public void setNomeInstiuicao(String nomeInstiuicao) {
		this.nomeInstiuicao = nomeInstiuicao;
	}

	public Integer getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}

}
