package br.com.crowfunding.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import br.com.crowfunding.enums.Arquivo;

public class ArquivoRepository {

	private BufferedWriter arquivoRepository;
	private Arquivo arquivo;

	public ArquivoRepository(Arquivo arquivo) {
		this.arquivo = arquivo;
		File file = new File(Arquivo.getNomeArquivo(arquivo));
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void persistirJson(String json) throws IOException {

		arquivoRepository = new BufferedWriter(new FileWriter(Arquivo.getNomeArquivo(arquivo), false));
		this.arquivoRepository.write(json);
		this.arquivoRepository.close();

	}

	public BufferedReader recuperarJson() throws IOException {

		BufferedReader bufferedReader = null;
		bufferedReader = new BufferedReader(new FileReader(Arquivo.getNomeArquivo(this.getArquivo())));
		return bufferedReader;

	}

	public boolean isArquivoVazio() {
		return new File(Arquivo.getNomeArquivo(this.getArquivo())).length() == 0;
	}

	public Arquivo getArquivo() {
		return this.arquivo;
	}

}
