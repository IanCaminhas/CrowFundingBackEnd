package br.com.crowfunding.enums;

public enum Arquivo {

	ALUNO("C:\\alunos.json"), INSTITUICAO("C:\\instituicoes.json");

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
