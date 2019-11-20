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

import com.google.gson.GsonBuilder;

import br.com.crowfunding.dao.CursoDao;
import br.com.crowfunding.dao.InstituicaoDao;
import br.com.crowfunding.dto.CursoDTO;
import br.com.crowfunding.model.Curso;

@Path("cursos")
public class CursoResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("adiciona")
	public Response adicionarCurso(String dadosCurso) {

		CursoDTO cursoDTO = this.dtoParaCurso(dadosCurso);

		Curso curso = new CursoDao().adiciona(
				new Curso(cursoDTO.getNome(), cursoDTO.getValor(), cursoDTO.getEmenta(), cursoDTO.getIdInstituicao()));
		new InstituicaoDao().adicionarCurso(curso.getId(), curso.getIdInstituicao());

		return Response.ok().build();

	}

	@Path("/{idInstituicao}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getCursos(@PathParam("idInstituicao") Integer id) {
		List<CursoDTO> cursosDaInstituicao = new CursoDao().getCursosDaInstituicao(id);

		return new GsonBuilder().setPrettyPrinting().create().toJson(cursosDaInstituicao);
	}

	private CursoDTO dtoParaCurso(String conteudo) {
		return new GsonBuilder().setPrettyPrinting().create().fromJson(conteudo, CursoDTO.class);
	}

}
