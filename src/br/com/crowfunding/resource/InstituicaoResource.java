package br.com.crowfunding.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.GsonBuilder;

import br.com.crowfunding.dao.InstituicaoDao;
import br.com.crowfunding.model.Instituicao;


@Path("instituicoes")
public class InstituicaoResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response adiciona(String conteudo) {
		
		
		
		Instituicao instituicao = new GsonBuilder().setPrettyPrinting().create().fromJson(conteudo, Instituicao.class);
		
		new InstituicaoDao().adiciona(instituicao);
		URI uri = URI.create("instituicoes/");
		return Response.created(uri).build();
		
		}
	
	
	
	
		
}
