package br.com.crowfunding.dto;

public class MatriculaAlunoDTO {

	private Integer idTurma;
	private Integer idAluno;

	public MatriculaAlunoDTO(Integer idTurma, Integer idAluno) {
		this.idTurma = idTurma;
		this.idAluno = idAluno;
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

}
