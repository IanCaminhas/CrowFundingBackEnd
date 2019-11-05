package br.com.crowfunding.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.crowfunding.dao.CursoDao;
import br.com.crowfunding.dao.EnderecoDao;
import br.com.crowfunding.dao.InstituicaoDao;
import br.com.crowfunding.dao.TurmaDao;
import br.com.crowfunding.dto.CursoDTO;
import br.com.crowfunding.dto.InstituicaoDTO;
import br.com.crowfunding.dto.TurmaDTO;
import br.com.crowfunding.model.Curso;
import br.com.crowfunding.model.Endereco;
import br.com.crowfunding.model.Instituicao;
import br.com.crowfunding.model.Turma;

@Path("instituicoes")
public class InstituicaoResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("cadastrar")
	public Response cadastrarInstituicao(String dadosInstituicao) {
		InstituicaoDTO instituicaoDTO = this.dtoParaInstituicao(dadosInstituicao);
		System.out.println(dadosInstituicao);
		Endereco endereco = new EnderecoDao().adiciona(instituicaoDTO.getRua(), instituicaoDTO.getBairro(),
				instituicaoDTO.getNumeroPropriedade(), instituicaoDTO.getComplemento(), instituicaoDTO.getLogradouro());

		Instituicao instituicao = new Instituicao(instituicaoDTO.getNome(), instituicaoDTO.getCnpj(),
				instituicaoDTO.getTelefone(), instituicaoDTO.getEmail(), instituicaoDTO.getResponsavel(),
				instituicaoDTO.getDescricao(), instituicaoDTO.getConta(), instituicaoDTO.getAgencia(),
				instituicaoDTO.getSenha(), endereco.getId());

		instituicao = new InstituicaoDao().adiciona(instituicao);

		instituicaoDTO.setId(instituicao.getId());

		return Response.ok(new Gson().toJson(instituicaoDTO)).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("cursos")
	public Response adicionarCurso(String dadosCurso) {

		CursoDTO cursoDTO = this.dtoParaCurso(dadosCurso);

		Curso curso = new CursoDao().adiciona(
				new Curso(cursoDTO.getNome(), cursoDTO.getValor(), cursoDTO.getEmenta(), cursoDTO.getIdInstituicao()));
		new InstituicaoDao().adicionarCurso(curso.getId(), curso.getIdInstituicao());

		return Response.ok().build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("turmas")
	public Response adicionarTurma(String dadosTurma) {

		TurmaDTO turmaDTO = this.dtoParaTurma(dadosTurma);

		Turma turma = new TurmaDao().adiciona(
				new Turma(turmaDTO.getNumeroVagas(), turmaDTO.getHorarioInicio(), turmaDTO.getHorarioTermino(),
						turmaDTO.getDataInicio(), turmaDTO.getHorarioTermino(), turmaDTO.getIdCurso()));
		new CursoDao().adicionarTurma(turma.getIdCurso(), turma.getId());
		return Response.status(201).build();

	}

	@Path("cursos/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getCursos(@PathParam("id") Integer id) {
		System.out.println(id);
		List<CursoDTO> cursosDaInstituicao = new CursoDao().getCursosDaInstituicao(id);
		
		return new GsonBuilder().setPrettyPrinting().create().toJson(cursosDaInstituicao);
	}

	private InstituicaoDTO dtoParaInstituicao(String conteudo) {
		return new GsonBuilder().setPrettyPrinting().create().fromJson(conteudo, InstituicaoDTO.class);
	}

	private CursoDTO dtoParaCurso(String conteudo) {
		return new GsonBuilder().setPrettyPrinting().create().fromJson(conteudo, CursoDTO.class);
	}

	private TurmaDTO dtoParaTurma(String conteudo) {
		return new GsonBuilder().setPrettyPrinting().create().fromJson(conteudo, TurmaDTO.class);
	}

}
