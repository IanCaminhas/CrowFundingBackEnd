package br.com.crowfunding.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.GsonBuilder;

import br.com.crowfunding.dao.MatriculaDao;
import br.com.crowfunding.dao.TurmaDao;
import br.com.crowfunding.dto.MatriculasDaInstituicaoDTO;
import br.com.crowfunding.dto.MatriculaAlunoDTO;
import br.com.crowfunding.dto.MatriculaDoAlunoDTO;
import br.com.crowfunding.dto.TurmaCursoInstituicaoDTO;
import br.com.crowfunding.model.Matricula;
import br.com.crowfunding.utils.Data;

@Path("matriculas")
public class MatriculaResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("matricularAluno")
	public Response matricularAluno(String dadosMatricula) {
		MatriculaAlunoDTO matriculaDTO = this.dtoParaMatricula(dadosMatricula);
		Matricula matricula = new Matricula(Data.obterDataHoje().toString(), matriculaDTO.getIdTurma(),
				matriculaDTO.getIdAluno());
		new MatriculaDao().adiciona(matricula);

		return Response.status(201).build();

	}

	private MatriculaAlunoDTO dtoParaMatricula(String conteudo) {
		return new GsonBuilder().setPrettyPrinting().create().fromJson(conteudo, MatriculaAlunoDTO.class);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("aprovar")
	public Response aprovarAluno(String dadosMatricula) {
		MatriculaAlunoDTO matriculaDTO = this.dtoParaMatricula(dadosMatricula);
		new MatriculaDao().aprovarAluno(matriculaDTO.getIdAluno(), matriculaDTO.getIdTurma());

		return Response.status(201).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("reprovar")
	public Response reprovarAluno(String dadosMatricula) {
		MatriculaAlunoDTO matriculaDTO = this.dtoParaMatricula(dadosMatricula);

		new MatriculaDao().reprovarAluno(matriculaDTO.getIdAluno(), matriculaDTO.getIdTurma());

		return Response.status(201).build();

	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("turmasDisponiveis")
	public String turmasDisponiveis() {
		ArrayList<TurmaCursoInstituicaoDTO> turmasParaMatricula = new TurmaDao().getTurmasValidas();
		return new GsonBuilder().setPrettyPrinting().create().toJson(turmasParaMatricula);

	}

	@Path("analise/{idInstituicao}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getMatriculasDaInstituicao(@PathParam("idInstituicao") Integer id) {
		List<MatriculasDaInstituicaoDTO> matriculasDaInstituicao = new MatriculaDao().matriculasDaInstituicao(id);

		return new GsonBuilder().setPrettyPrinting().create().toJson(matriculasDaInstituicao);
	}

	@Path("matriculas_aluno/{idAluno}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getMatriculasDoAluno(@PathParam("idAluno") Integer id) {
		ArrayList<MatriculaDoAlunoDTO> matriculasDoAluno = new MatriculaDao().matriculasDoAluno(id);
		return new GsonBuilder().setPrettyPrinting().create().toJson(matriculasDoAluno);
	}

}
