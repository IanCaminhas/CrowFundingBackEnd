package br.com.crowfunding.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.GsonBuilder;

import br.com.crowfunding.dao.InstituicaoDao;
import br.com.crowfunding.model.Instituicao;

@Path("instituicao/login")
public class LoginInstituicaoResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(String conteudo) {
		

		Instituicao instituicao = new GsonBuilder().setPrettyPrinting().create().fromJson(conteudo, Instituicao.class);
		
		boolean credenciaisValidas = new InstituicaoDao().validaCredenciais(instituicao);
		
		if(!credenciaisValidas) {
			return Response.status(404).build();
		}
	
		return Response.status(200).build();
		
		
		
		

	}

}
