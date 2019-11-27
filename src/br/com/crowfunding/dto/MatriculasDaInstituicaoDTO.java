package br.com.crowfunding.dto;

public class MatriculasDaInstituicaoDTO {

	private String nomeAluno;
	private String nomeCurso;
	private String horaInicio;
	private String horaTermino;
	private String dataInicio;
	private String dataTermino;
	private String status;
	private Integer idAluno;
	private Integer idTurma;
	private String enderecoAluno;
	private Double rendaPerCapita;
	private String descricaoPerfil;
	private String ementa;
	private String endereco;
	
	public MatriculasDaInstituicaoDTO(String nomeAluno, String nomeCurso, String horaInicio, String horaTermino,
			String dataInicio, String dataTermino, String status, Integer idAluno, Integer idTurma,
			String enderecoAluno, Double rendaPerCapita, String descricaoPerfil, String ementa) {

		this.nomeAluno = nomeAluno;
		this.nomeCurso = nomeCurso;
		this.horaInicio = horaInicio;
		this.horaTermino = horaTermino;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.status = status;
		this.idAluno = idAluno;
		this.idTurma = idTurma;
		this.enderecoAluno = enderecoAluno;
		this.rendaPerCapita = rendaPerCapita;
		this.descricaoPerfil = descricaoPerfil;
		this.ementa = ementa;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public Integer getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Integer idTurma) {
		this.idTurma = idTurma;
	}

	public String getEnderecoAluno() {
		return enderecoAluno;
	}

	public void setEnderecoAluno(String enderecoAluno) {
		this.enderecoAluno = enderecoAluno;
	}

	public Double getRendaPerCapita() {
		return rendaPerCapita;
	}

	public void setRendaPerCapita(Double rendaPerCapita) {
		this.rendaPerCapita = rendaPerCapita;
	}

	public String getDescricaoPerfil() {
		return descricaoPerfil;
	}

	public void setDescricaoPerfil(String descricaoPerfil) {
		this.descricaoPerfil = descricaoPerfil;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
