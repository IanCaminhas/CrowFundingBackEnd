package br.com.crowfunding.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.GsonBuilder;

import br.com.crowfunding.dao.MatriculaDao;
import br.com.crowfunding.dto.MatriculaAlunoDTO;
import br.com.crowfunding.model.Matricula;
import br.com.crowfunding.utils.Data;

@Path("matriculas")
public class MatriculaResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("matricular")
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
	
	
	
	
	
	
	
	
	

	

}
