package br.com.crowfunding.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.crowfunding.dao.AlunoDao;
import br.com.crowfunding.dao.EnderecoDao;
import br.com.crowfunding.dao.InstituicaoDao;
import br.com.crowfunding.dto.AlunoDTO;
import br.com.crowfunding.dto.UsuarioDTO;
import br.com.crowfunding.enums.Arquivo;
import br.com.crowfunding.model.Aluno;
import br.com.crowfunding.model.Endereco;
import br.com.crowfunding.repository.ArquivoRepository;

@Path("alunos")
public class AlunoResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("cadastrar")
	public Response adiciona(String dadosAluno) {
		AlunoDTO alunoDTO = this.fromDTO(dadosAluno);

		if (!new ArquivoRepository(Arquivo.ALUNO).isArquivoVazio()) {
			if (new InstituicaoDao().verifcaEmailExistente(alunoDTO.getEmail())) {
				return Response.status(404).build();
			}
		}

		Endereco endereco = new EnderecoDao().adiciona(alunoDTO.getRua(), alunoDTO.getBairro(),
				alunoDTO.getNumeroPropriedade(), alunoDTO.getComplemento(), alunoDTO.getLogradouro());

		Aluno aluno = new Aluno(alunoDTO.getNome(), alunoDTO.getTelefone(), alunoDTO.getEmail(), alunoDTO.getCpf(),
				alunoDTO.getDescricaoPerfil(), alunoDTO.getRendaPerCapita(), alunoDTO.getSenha(), endereco.getId(),
				alunoDTO.getDataNascimento());

		Aluno a = new AlunoDao().adiciona(aluno);
		alunoDTO.setId(a.getId());

		return Response.ok(new Gson().toJson(alunoDTO)).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("login")
	public Response login(String credenciais) {

		UsuarioDTO user = new GsonBuilder().setPrettyPrinting().create().fromJson(credenciais, UsuarioDTO.class);

		AlunoDTO alunoDTO = new AlunoDao().validaCredenciais(user);

		if (alunoDTO.equals(null)) {
			return Response.status(404).build();
		}

		return Response.ok(new Gson().toJson(alunoDTO)).build();
	}

	private AlunoDTO fromDTO(String conteudo) {
		return new GsonBuilder().setPrettyPrinting().create().fromJson(conteudo, AlunoDTO.class);
	}

}
