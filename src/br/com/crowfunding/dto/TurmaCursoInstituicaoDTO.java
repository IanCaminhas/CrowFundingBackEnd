package br.com.crowfunding.dto;

public class TurmaCursoInstituicaoDTO {

	private Integer idTurma;
	private String nomeCurso;
	private String nomeInstituivao;
	private Double valorCurso;
	private String dataInicio;
	private String dataConclusao;
	private String horarioInicio;
	private String horarioTermino;
	private String endereco;

	public TurmaCursoInstituicaoDTO(Integer idTurma, String nomeCurso, String nomeInstituivao, Double valorCurso,
			String dataInicio, String dataConclusao, String horarioInicio, String horarioTermino, String endereco) {
		this.idTurma = idTurma;
		this.nomeCurso = nomeCurso;
		this.nomeInstituivao = nomeInstituivao;
		this.valorCurso = valorCurso;
		this.dataInicio = dataInicio;
		this.dataConclusao = dataConclusao;
		this.horarioInicio = horarioInicio;
		this.horarioTermino = horarioTermino;
		this.endereco = endereco;
	}

	public Integer getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getNomeInstituivao() {
		return nomeInstituivao;
	}

	public void setNomeInstituivao(String nomeInstituivao) {
		this.nomeInstituivao = nomeInstituivao;
	}

	public Double getValorCurso() {
		return valorCurso;
	}

	public void setValorCurso(Double valorCurso) {
		this.valorCurso = valorCurso;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(String dataConclusao) {
		this.dataConclusao = dataConclusao;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
