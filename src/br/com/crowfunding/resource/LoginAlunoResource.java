package br.com.crowfunding.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.GsonBuilder;

import br.com.crowfunding.dao.AlunoDao;
import br.com.crowfunding.model.Aluno;

@Path("aluno/login")
public class LoginAlunoResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(String conteudo) {

		Aluno aluno = new GsonBuilder().setPrettyPrinting().create().fromJson(conteudo, Aluno.class);

		boolean credenciaisValidas = new AlunoDao().validaCredenciais(aluno);

		if (!credenciaisValidas) {
			return Response.status(404).build();
		}

		return Response.status(200).build();
	}

}
