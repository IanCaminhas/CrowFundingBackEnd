package br.com.crowfunding.dao;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.crowfunding.enums.Arquivo;
import br.com.crowfunding.model.Doacao;
import br.com.crowfunding.repository.ArquivoRepository;

public class DoacaoDao {

	private ArquivoRepository repository;

	public DoacaoDao() {
		this.repository = new ArquivoRepository(Arquivo.DOACOES);
	}

	public Doacao adiciona(Doacao doacao) {

		Map<String, ArrayList<Doacao>> matriculasMap = this.getDoacoes();
		int totalDoacoes;

		if (repository.isArquivoVazio() || matriculasMap.get("doacoes") == (null)) {
			matriculasMap = new HashMap<String, ArrayList<Doacao>>();
			matriculasMap.put("doacoes", new ArrayList<Doacao>());
			totalDoacoes = 0;
		} else {
			totalDoacoes = matriculasMap.get("doacoes").size();
		}

		totalDoacoes++;
		doacao.setId(totalDoacoes);
		matriculasMap.get("doacoes").add(doacao);

		persistir(matriculasMap);

		return doacao;

	}

	private void persistir(Map<String, ArrayList<Doacao>> matriculasMap) {
		String jsonListaDoacoes = new GsonBuilder().setPrettyPrinting().create().toJson(matriculasMap);

		try {
			repository.persistirJson(jsonListaDoacoes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Map<String, ArrayList<Doacao>> getDoacoes() {

		Map<String, ArrayList<Doacao>> doacoesMap = null;

		Type listaDoacaos = new TypeToken<HashMap<String, ArrayList<Doacao>>>() {
		}.getType();

		try {
			doacoesMap = new GsonBuilder().setPrettyPrinting().create().fromJson(repository.recuperarJson(),
					listaDoacaos);

			repository.recuperarJson().close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return doacoesMap;

	}
	
	
	
	
	

}
