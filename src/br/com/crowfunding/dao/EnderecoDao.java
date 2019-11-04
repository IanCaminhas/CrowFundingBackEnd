package br.com.crowfunding.dao;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.crowfunding.enums.Arquivo;
import br.com.crowfunding.model.Endereco;
import br.com.crowfunding.repository.ArquivoRepository;

public class EnderecoDao {

	private ArquivoRepository repository;

	public EnderecoDao() {
		this.repository = new ArquivoRepository(Arquivo.ENDERECO);
	}

	public Endereco adiciona(String rua, String bairro, Integer numeroPropriedade, String complemento,
			String logradouro) {

		Endereco endereco = new Endereco(rua, bairro, numeroPropriedade, complemento, logradouro);

		Map<String, ArrayList<Endereco>> matriculasMap = this.getEnderecos();

		int totalEnderecos;
		if (repository.isArquivoVazio() || matriculasMap.get("enderecos") == null) {
			matriculasMap = new HashMap<String, ArrayList<Endereco>>();
			matriculasMap.put("enderecos", new ArrayList<Endereco>());
			totalEnderecos = 0;
		} else {
			totalEnderecos = matriculasMap.get("enderecos").size();
		}

		totalEnderecos++;
		endereco.setId(totalEnderecos);
		matriculasMap.get("enderecos").add(endereco);

		persistir(matriculasMap);

		return endereco;

	}

	private void persistir(Map<String, ArrayList<Endereco>> matriculasMap) {
		String jsonListaEnderecos = new GsonBuilder().setPrettyPrinting().create().toJson(matriculasMap);

		try {
			repository.persistirJson(jsonListaEnderecos);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Map<String, ArrayList<Endereco>> getEnderecos() {

		Map<String, ArrayList<Endereco>> enderecosMap = null;

		Type listaInstituicoes = new TypeToken<HashMap<String, ArrayList<Endereco>>>() {
		}.getType();
		
		try {
			enderecosMap = new GsonBuilder().setPrettyPrinting().create().fromJson(repository.recuperarJson(),
					listaInstituicoes);
			repository.recuperarJson().close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return enderecosMap;

	}

}
