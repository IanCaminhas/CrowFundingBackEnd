package br.com.crowfunding.enums;

public enum Arquivo {

	ALUNO("C:\\alunos.json"), INSTITUICAO("C:\\instituicoes.json"), ENDERECO("C:\\enderecos.json"), CURSO("C:\\cursos.json"),TURMA("C:\\turmas.json"),
	MATRICULAS("C:\\matriculas.json"), DOACOES("C:\\doacoes.json") ;
	
	
	private String nomeArquivo;

	private Arquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public static String getNomeArquivo(Arquivo arquivo) {

		for (Arquivo x : Arquivo.values()) {
			if (x.equals(arquivo))
				return x.nomeArquivo;
		}

		return null;

	}

}
