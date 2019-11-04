package br.com.crowfunding.dto;

public class TurmaDTO {

	private Integer numeroVagas;
	private String horarioInicio;
	private String horarioTermino;
	private String dataInicio;
	private String previsaoTermino;
	private Integer idCurso;
	
	public TurmaDTO(Integer numeroVagas, String horarioInicio, String horarioTermino, String dataInicio,
			String previsaoTermino, Integer idCurso) {
		this.numeroVagas = numeroVagas;
		this.horarioInicio = horarioInicio;
		this.horarioTermino = horarioTermino;
		this.dataInicio = dataInicio;
		this.previsaoTermino = previsaoTermino;
		this.idCurso = idCurso;
	}
	public Integer getNumeroVagas() {
		return numeroVagas;
	}
	public void setNumeroVagas(Integer numeroVagas) {
		this.numeroVagas = numeroVagas;
	}
	public String getHorarioInicio() {
		return horarioInicio;
	}
	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	public String getHorarioTermino() {
		return horarioTermino;
	}
	public void setHorarioTermino(String horarioTermino) {
		this.horarioTermino = horarioTermino;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getPrevisaoTermino() {
		return previsaoTermino;
	}
	public void setPrevisaoTermino(String previsaoTermino) {
		this.previsaoTermino = previsaoTermino;
	}
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	
	
	
	
	
}
