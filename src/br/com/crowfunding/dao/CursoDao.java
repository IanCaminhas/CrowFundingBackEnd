package br.com.crowfunding.dao;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.crowfunding.enums.Arquivo;
import br.com.crowfunding.model.Curso;
import br.com.crowfunding.repository.ArquivoRepository;

public class CursoDao {

	private ArquivoRepository repository;

	public CursoDao() {
		this.repository = new ArquivoRepository(Arquivo.CURSO);
	}

	public Curso adiciona(Curso curso) {

		

		Map<String, ArrayList<Curso>> cursosMap = this.getCursos();

		int totalCursos;
		if (repository.isArquivoVazio() || cursosMap.get("cursos") == null) {
			cursosMap = new HashMap<String, ArrayList<Curso>>();
			cursosMap.put("cursos", new ArrayList<Curso>());
			totalCursos = 0;
		} else {
			totalCursos = cursosMap.get("cursos").size();
		}

		totalCursos++;
		curso.setId(totalCursos);
		cursosMap.get("cursos").add(curso);

		persistir(cursosMap);

		return curso;

	}

	private void persistir(Map<String, ArrayList<Curso>> cursosMap) {
		String jsonListaCursos = new GsonBuilder().setPrettyPrinting().create().toJson(cursosMap);

		try {
			repository.persistirJson(jsonListaCursos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Map<String, ArrayList<Curso>> getCursos() {

		Map<String, ArrayList<Curso>> cursosMap = null;

		Type listaCursos = new TypeToken<HashMap<String, ArrayList<Curso>>>() {
		}.getType();

		try {
			cursosMap = new GsonBuilder().setPrettyPrinting().create().fromJson(repository.recuperarJson(),
					listaCursos);
			repository.recuperarJson().close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return cursosMap;

	}

	public void adicionarTurma(Integer idCurso, Integer idTurma) {
		Map<String, ArrayList<Curso>> cursosMap = this.getCursos();

		boolean busca = false;
		int cont = 0;
		int totalCursos = cursosMap.get("cursos").size();

		while (!busca && (cont < totalCursos)) {

			if (cursosMap.get("cursos").get(cont).getId().equals(idCurso)) {
				cursosMap.get("cursos").get(cont).getTurmas().add(idTurma);
				busca = true;
			}

			cont++;

		}

		persistir(cursosMap);

	}

}
