package br.com.crowfunding.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.GsonBuilder;

import br.com.crowfunding.dao.MatriculaDao;
import br.com.crowfunding.dto.DadosParaDoacaoDTO;

@Path("doacoes")
public class DoacaoResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("doar")
	public Response doarParaAluno(String dadosDoacao) {

		
		
		
		
		
		return Response.status(201).build();

	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("doacao/alunos")
	public String dadosParaDoacao(String dadosDoacao) {

		List<DadosParaDoacaoDTO> dadosParaDoacoes = new MatriculaDao().getDadosParaRealizarDoacao();

		return new GsonBuilder().setPrettyPrinting().create().toJson(dadosParaDoacoes);

	}

}
