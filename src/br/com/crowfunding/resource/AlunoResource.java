package br.com.crowfunding.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.GsonBuilder;

import br.com.crowfunding.dao.AlunoDao;
import br.com.crowfunding.model.Aluno;

//https://stackoverflow.com/questions/28065963/how-to-handle-cors-using-jax-rs-with-jersey

@Path("alunos")
public class AlunoResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response adiciona(String conteudo) {

		Aluno aluno = new GsonBuilder().setPrettyPrinting().create().fromJson(conteudo, Aluno.class);
		new AlunoDao().adiciona(aluno);
		URI uri = URI.create("alunos/");
		return Response.created(uri).build();

	}

	

}
