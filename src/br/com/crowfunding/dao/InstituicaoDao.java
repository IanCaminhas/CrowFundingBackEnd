package br.com.crowfunding.dao;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.crowfunding.enums.Arquivo;
import br.com.crowfunding.model.Instituicao;
import br.com.crowfunding.repository.ArquivoRepository;

public class InstituicaoDao {

	private ArquivoRepository repository;

	public InstituicaoDao() {
		this.repository = new ArquivoRepository(Arquivo.INSTITUICAO);
	}

	public void adiciona(Instituicao Instituicao) {
		Map<String, ArrayList<Instituicao>> matriculasMap = this.getInstituicaos();

		int totalinstituicoes;
		if (repository.isArquivoVazio() || matriculasMap.get("instituicoes") == null) {
			matriculasMap = new HashMap<String, ArrayList<Instituicao>>();
			System.out.println(matriculasMap);
			matriculasMap.put("instituicoes", new ArrayList<Instituicao>());
			totalinstituicoes = 0;
		} else {
			totalinstituicoes = matriculasMap.get("instituicoes").size();
		}

		totalinstituicoes++;
		Instituicao.setId(totalinstituicoes);
		matriculasMap.get("instituicoes").add(Instituicao);

		String jsonListaInstituicaos = new GsonBuilder().setPrettyPrinting().create().toJson(matriculasMap);

		try {
			repository.persistirJson(jsonListaInstituicaos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Map<String, ArrayList<Instituicao>> getInstituicaos() {

		Map<String, ArrayList<Instituicao>> matriculasMap = null;

		Type listaInstituicoes = new TypeToken<HashMap<String, ArrayList<Instituicao>>>() {
		}.getType();

		matriculasMap = new GsonBuilder().setPrettyPrinting().create().fromJson(repository.recuperarJson(),
				listaInstituicoes);

		try {
			repository.recuperarJson().close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return matriculasMap;

	}
	
	public boolean validaCredenciais(Instituicao instituicao) {
		Map<String, ArrayList<Instituicao>> instituicoesMap = this.getInstituicaos();

		ArrayList<Instituicao> instituicoes = instituicoesMap.get("instituicoes");

		for (Instituicao i : instituicoes) {
			
			if(i.getEmail().equals(instituicao.getEmail())) {
				if(i.getSenha().equals(instituicao.getSenha())) {
					return true;
					
				}
			}
			
		}
		return false;

	}
	
	
	
	

}
