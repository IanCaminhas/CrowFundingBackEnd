package br.com.crowfunding.dao;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.crowfunding.enums.Arquivo;
import br.com.crowfunding.model.Turma;
import br.com.crowfunding.repository.ArquivoRepository;

public class TurmaDao {

	private ArquivoRepository repository;

	public TurmaDao() {
		this.repository = new ArquivoRepository(Arquivo.TURMA);
	}

	public Turma adiciona(Turma turma) {

		Map<String, ArrayList<Turma>> matriculasMap = this.getTurmas();
		int totalTurmas;

		if (repository.isArquivoVazio() || matriculasMap.get("turmas") == (null)) {
			matriculasMap = new HashMap<String, ArrayList<Turma>>();
			matriculasMap.put("turmas", new ArrayList<Turma>());
			totalTurmas = 0;
		} else {
			totalTurmas = matriculasMap.get("turmas").size();
		}

		totalTurmas++;
		turma.setId(totalTurmas);
		matriculasMap.get("turmas").add(turma);

		persistir(matriculasMap);

		return turma;

	}

	private void persistir(Map<String, ArrayList<Turma>> matriculasMap) {
		String jsonListaAlunos = new GsonBuilder().setPrettyPrinting().create().toJson(matriculasMap);

		try {
			repository.persistirJson(jsonListaAlunos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Map<String, ArrayList<Turma>> getTurmas() {

		Map<String, ArrayList<Turma>> turmasMap = null;

		Type listaTurmas = new TypeToken<HashMap<String, ArrayList<Turma>>>() {
		}.getType();

		try {
			turmasMap = new GsonBuilder().setPrettyPrinting().create().fromJson(repository.recuperarJson(),
					listaTurmas);

			repository.recuperarJson().close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return turmasMap;

	}

}
