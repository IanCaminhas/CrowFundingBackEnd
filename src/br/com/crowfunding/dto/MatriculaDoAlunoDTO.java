package br.com.crowfunding.dto;

public class MatriculaDoAlunoDTO {

	private String nomeCurso;
	private String nomeInstituicao;
	private String status;
	private String horaInicio;
	private String horaTermino;
	private String dataInicio;
	private String dataTermino;
	private String ementa;
	private Double valorCurso;
	private Double valorArrecadado;

	public MatriculaDoAlunoDTO(String nomeCurso, String nomeInstituicao, String status, String horaInicio,
			String horaTermino, String dataInicio, String dataTermino, String ementa, Double valorCurso,
			Double valorArrecadado) {

		this.nomeCurso = nomeCurso;
		this.nomeInstituicao = nomeInstituicao;
		this.status = status;
		this.horaInicio = horaInicio;
		this.horaTermino = horaTermino;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.ementa = ementa;
		this.valorArrecadado = valorArrecadado;
		this.valorCurso = valorCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getNomeInstistuicao() {
		return nomeInstituicao;
	}

	public void setNomeInstistuicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(String horaTermino) {
		this.horaTermino = horaTermino;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public Double getValorCurso() {
		return valorCurso;
	}

	public void setValorCurso(Double valorCurso) {
		this.valorCurso = valorCurso;
	}

	public Double getValorArrecadado() {
		return valorArrecadado;
	}

	public void setValorArrecadado(Double valorArrecadado) {
		this.valorArrecadado = valorArrecadado;
	}

}
