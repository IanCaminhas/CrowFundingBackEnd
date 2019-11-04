package br.com.crowfunding.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.GsonBuilder;

import br.com.crowfunding.dao.AlunoDao;
import br.com.crowfunding.dao.EnderecoDao;
import br.com.crowfunding.dto.AlunoDTO;
import br.com.crowfunding.model.Aluno;
import br.com.crowfunding.model.Endereco;

@Path("alunos")
public class AlunoResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("cadastrar")
	public Response adiciona(String dadosAluno) {
		System.out.println(dadosAluno);
		AlunoDTO alunoDTO = this.fromDTO(dadosAluno);

		Endereco endereco = new EnderecoDao().adiciona(alunoDTO.getRua(), alunoDTO.getBairro(),
				alunoDTO.getNumeroPropriedade(), alunoDTO.getComplemento(), alunoDTO.getLogradouro());

		Aluno aluno = new Aluno(alunoDTO.getNome(), alunoDTO.getTelefone(), alunoDTO.getEmail(), alunoDTO.getCpf(),
				alunoDTO.getDescricaoPerfil(), alunoDTO.getRendaPerCapita(), alunoDTO.getSenha(), endereco.getId());

		new AlunoDao().adiciona(aluno);

		return Response.status(201).build();
	}

	private AlunoDTO fromDTO(String conteudo) {
		return new GsonBuilder().setPrettyPrinting().create().fromJson(conteudo, AlunoDTO.class);
	}

}
