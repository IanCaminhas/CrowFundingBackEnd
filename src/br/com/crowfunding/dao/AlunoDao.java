package br.com.crowfunding.dao;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.crowfunding.enums.Arquivo;
import br.com.crowfunding.model.Aluno;
import br.com.crowfunding.repository.ArquivoRepository;

public class AlunoDao {

	private ArquivoRepository repository;

	public AlunoDao() {
		this.repository = new ArquivoRepository(Arquivo.ALUNO);
	}

	public void adiciona(Aluno aluno) {
		Map<String, ArrayList<Aluno>> matriculasMap = this.getAlunos();
		int totalAlunos;

		if (repository.isArquivoVazio() || matriculasMap.get("alunos") == (null)) {
			matriculasMap = new HashMap<String, ArrayList<Aluno>>();
			matriculasMap.put("alunos", new ArrayList<Aluno>());
			totalAlunos = 0;
		} else {
			totalAlunos = matriculasMap.get("alunos").size();
		}

		totalAlunos++;
		aluno.setId(totalAlunos);
		matriculasMap.get("alunos").add(aluno);

		String jsonListaAlunos = new GsonBuilder().setPrettyPrinting().create().toJson(matriculasMap);

		try {
			repository.persistirJson(jsonListaAlunos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Map<String, ArrayList<Aluno>> getAlunos() {

		Map<String, ArrayList<Aluno>> matriculasMap = null;

		Type listaAlunos = new TypeToken<HashMap<String, ArrayList<Aluno>>>() {
		}.getType();

		matriculasMap = new GsonBuilder().setPrettyPrinting().create().fromJson(repository.recuperarJson(),
				listaAlunos);

		try {
			repository.recuperarJson().close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return matriculasMap;

	}

	public boolean validaCredenciais(Aluno aluno) {
		Map<String, ArrayList<Aluno>> matriculasMap = this.getAlunos();

		ArrayList<Aluno> alunos = matriculasMap.get("alunos");

		for (Aluno a : alunos) {
			
			if(a.getEmail().equals(aluno.getEmail())) {
				if(a.getSenha().equals(aluno.getSenha())) {
					return true;
					
				}
			}
			
		}
		return false;

	}

}
