package br.com.crowfunding.model;

import br.com.crowfunding.enums.EstadoMatricula;

public class Matricula {

	private double montanteDoacao;
	private Integer estadoMatricula;
	private String dataMatricula;
	private Integer idTurma;
	private Integer idAluno;
	
	public Matricula(String dataMatricula, Integer idTurma, Integer idAluno) {
		this.dataMatricula = dataMatricula;
		this.idTurma = idTurma;
		this.idAluno = idAluno;
		this.montanteDoacao = 0;
		this.estadoMatricula= EstadoMatricula.getCodEstadoMatricula(EstadoMatricula.EMANALISE);
			
	}
	
	public double getMontanteDoacao() {
		return montanteDoacao;
	}

	public void setMontanteDoacao(double montanteDoacao) {
		this.montanteDoacao = montanteDoacao;
	}

	public Integer getEstadoMatricula() {
		return estadoMatricula;
	}

	public void setEstadoMatricula(Integer estadoMatricula) {
		this.estadoMatricula = estadoMatricula;
	}

	public String getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
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
