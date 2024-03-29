package br.com.crowfunding.dao;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.crowfunding.dto.InstituicaoDTO;
import br.com.crowfunding.dto.UsuarioDTO;
import br.com.crowfunding.enums.Arquivo;
import br.com.crowfunding.model.Endereco;
import br.com.crowfunding.model.Instituicao;
import br.com.crowfunding.repository.ArquivoRepository;

public class InstituicaoDao {

	private ArquivoRepository repository;

	public InstituicaoDao() {
		this.repository = new ArquivoRepository(Arquivo.INSTITUICAO);
	}

	public boolean verifcaEmailExistente(String email) {
		ArrayList<Instituicao> arrayList = this.getInstituicaos().get("instituicoes");
		
		for (int i = 0; i < arrayList.size(); i++) {
			if(arrayList.get(i).getEmail().equals(email)) {
				return true;
			}
		}
		
		
		return false;
		
		
	}
	
	
	public Instituicao adiciona(Instituicao instituicao) {

		Map<String, ArrayList<Instituicao>> matriculasMap = this.getInstituicaos();

		int totalinstituicoes;
		if (repository.isArquivoVazio() || matriculasMap.get("instituicoes") == null) {
			matriculasMap = new HashMap<String, ArrayList<Instituicao>>();
			matriculasMap.put("instituicoes", new ArrayList<Instituicao>());
			totalinstituicoes = 0;
		} else {
			totalinstituicoes = matriculasMap.get("instituicoes").size();
		}

		totalinstituicoes++;
		instituicao.setId(totalinstituicoes);
		matriculasMap.get("instituicoes").add(instituicao);

		persistir(matriculasMap);

		return instituicao;
	}

	public void adicionarCurso(Integer idCurso, Integer idInstituicao) {
		Map<String, ArrayList<Instituicao>> instituicoesMap = this.getInstituicaos();

		boolean busca = false;
		int cont = 0;
		int totalInstituicoes = instituicoesMap.get("instituicoes").size();

		while (!busca && (cont < totalInstituicoes)) {
			if (instituicoesMap.get("instituicoes").get(cont).getId().equals(idInstituicao)) {
				instituicoesMap.get("instituicoes").get(cont).getCursos().add(idCurso);
				busca = true;
			}

			cont++;

		}

		persistir(instituicoesMap);

	}

	private void persistir(Map<String, ArrayList<Instituicao>> matriculasMap) {
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

		try {
			matriculasMap = new GsonBuilder().setPrettyPrinting().create().fromJson(repository.recuperarJson(),
					listaInstituicoes);

			repository.recuperarJson().close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return matriculasMap;

	}

	public InstituicaoDTO validaCredenciais(UsuarioDTO usuario) {
		Map<String, ArrayList<Instituicao>> instituicoesMap = this.getInstituicaos();

		ArrayList<Instituicao> instituicoes = instituicoesMap.get("instituicoes");

		for (Instituicao i : instituicoes) {

			if (i.getEmail().equals(usuario.getEmail())) {
				if (i.getSenha().equals(usuario.getSenha())) {

					Endereco endereco = new EnderecoDao().getEndereco(i.getIdEndereco());
					 InstituicaoDTO instituicaoDTO = new InstituicaoDTO(i.getNome(), i.getCnpj(), i.getTelefone(), i.getEmail(),
							i.getResponsavel(), i.getDescricao(), i.getConta(), i.getAgencia(), i.getSenha(),
							endereco.getRua(), endereco.getBairro(), endereco.getNumeroPropriedade(),
							endereco.getComplemento(), endereco.getLogradouro());
					 instituicaoDTO.setId(i.getId());
					 return instituicaoDTO;
					 
				}
			}

		}
		return null;

	}
	
	public Instituicao getInstituicao(Integer id) {

		ArrayList<Instituicao> list = this.getInstituicaos().get("instituicoes");

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId().equals(id)) {
				return list.get(i);
			}

		}

		return null;

	}
	
	
	
	

}
