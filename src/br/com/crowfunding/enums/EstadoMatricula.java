package br.com.crowfunding.enums;

public enum EstadoMatricula {

	EMANALISE(1, "Em análise pela instituição"), APROVADO(2, "Matricula aprovada pela instituição"),
	REPROVADO(3, "Matricula reprovada pela instituição"), FINALIZADO(4, "Curso realizado"),
	EMCURSO(5, " Curso em andamento");

	private Integer estado;
	private String situacao;

	private EstadoMatricula(Integer estado, String situacao) {
		this.estado = estado;
		this.situacao = situacao;
	}

	public static Integer getCodEstadoMatricula(EstadoMatricula estado) {

		for (EstadoMatricula e : EstadoMatricula.values()) {
			if (e.equals(estado))
				return e.getCodEstado();
		}

		return null;

	}
	
	public static String getDescricaoEstadoMatricula(Integer cod) {
		
		for (EstadoMatricula e : EstadoMatricula.values()) {
			if (e.getCodEstado().equals(cod))
				return e.getSituacao();
		}

		return null;
		
	}
	

	public String getSituacao() {
		return situacao;
	}

	public Integer getCodEstado() {
		return estado;
	}

}
