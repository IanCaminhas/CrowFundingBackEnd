package br.com.crowfunding.dao;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.crowfunding.dto.AlunoDTO;
import br.com.crowfunding.dto.UsuarioDTO;
import br.com.crowfunding.enums.Arquivo;
import br.com.crowfunding.model.Aluno;
import br.com.crowfunding.model.Endereco;
import br.com.crowfunding.repository.ArquivoRepository;

public class AlunoDao {

	private ArquivoRepository repository;

	public AlunoDao() {
		this.repository = new ArquivoRepository(Arquivo.ALUNO);
	}

	public Aluno adiciona(Aluno aluno) {

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

		persistir(matriculasMap);

		return aluno;

	}

	private void persistir(Map<String, ArrayList<Aluno>> matriculasMap) {
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

		try {
			matriculasMap = new GsonBuilder().setPrettyPrinting().create().fromJson(repository.recuperarJson(),
					listaAlunos);

			repository.recuperarJson().close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return matriculasMap;

	}

	public AlunoDTO validaCredenciais(UsuarioDTO usuario) {
		Map<String, ArrayList<Aluno>> instituicoesMap = this.getAlunos();

		ArrayList<Aluno> alunos = instituicoesMap.get("alunos");

		for (Aluno a : alunos) {

			if (a.getEmail().equals(usuario.getEmail())) {
				if (a.getSenha().equals(usuario.getSenha())) {

					Endereco endereco = new EnderecoDao().getEndereco(a.getIdEndereco());
					AlunoDTO alunoDTO = new AlunoDTO(a.getNome(), a.getTelefone(), a.getEmail(), a.getDataNascimento(),
							a.getCpf(), a.getDescricaoPerfil(), a.getRendaPerCapita(), a.getSenha(), endereco.getRua(),
							endereco.getBairro(), endereco.getNumeroPropriedade(), endereco.getComplemento(),
							endereco.getLogradouro());

					alunoDTO.setId(a.getId());
					return alunoDTO;

				}
			}

		}
		return null;

	}

}
