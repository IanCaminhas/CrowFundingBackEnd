package br.com.crowfunding.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.GsonBuilder;

import br.com.crowfunding.dao.CursoDao;
import br.com.crowfunding.dao.TurmaDao;
import br.com.crowfunding.dto.TurmaCursoInstituicaoDTO;
import br.com.crowfunding.dto.TurmaDTO;
import br.com.crowfunding.model.Turma;

@Path("turmas")
public class TurmaResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("adiciona")
	public Response adicionarTurma(String dadosTurma) {

		TurmaDTO turmaDTO = this.dtoParaTurma(dadosTurma);

		Turma turma = new TurmaDao().adiciona(
				new Turma(turmaDTO.getNumeroVagas(), turmaDTO.getHorarioInicio(), turmaDTO.getHorarioTermino(),
						turmaDTO.getDataInicio(), turmaDTO.getPrevisaoTermino(), turmaDTO.getIdCurso()));
		new CursoDao().adicionarTurma(turma.getIdCurso(), turma.getId());
		return Response.status(201).build();

	}

	private TurmaDTO dtoParaTurma(String conteudo) {
		return new GsonBuilder().setPrettyPrinting().create().fromJson(conteudo, TurmaDTO.class);
	}

	
	//turmas disponíveis
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("turmasDisponiveis")
	public String turmasDisponiveis() {
		ArrayList<TurmaCursoInstituicaoDTO> turmasParaMatricula = new TurmaDao().getTurmasValidas();
		return new GsonBuilder().setPrettyPrinting().create().toJson(turmasParaMatricula);

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("turmas_instituicao/{idInstituicao}")
	public String turmasDaInstituicao(@PathParam("idInstituicao") Integer id) {
		ArrayList<TurmaDTO> turmasParaMatricula = new TurmaDao().getTurmasDaInstituicao(id);
		return new GsonBuilder().setPrettyPrinting().create().toJson(turmasParaMatricula);

	}
	
	
	
	

}
