package br.com.crowfunding.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.GsonBuilder;

import br.com.crowfunding.dao.DoacaoDao;
import br.com.crowfunding.dao.MatriculaDao;
import br.com.crowfunding.dto.DadosParaDoacaoDTO;
import br.com.crowfunding.dto.DoacaoDTO;
import br.com.crowfunding.model.Doacao;

@Path("doacao")
public class DoacaoResource {

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("alunos")
	public String turmasDisponiveis() {
		ArrayList<DadosParaDoacaoDTO> dadosParaRealizarDoacao = new MatriculaDao().getDadosParaRealizarDoacao();
		return new GsonBuilder().setPrettyPrinting().create().toJson(dadosParaRealizarDoacao);
	}
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("realizar_doacao")
	public Response realizarDoacao(String dadosMatricula) {
		DoacaoDTO doacaoDTO = this.obterDoacaoDTO(dadosMatricula);
		
		
		Doacao doacao = new DoacaoDao().adiciona(new Doacao(doacaoDTO.getValor(), doacaoDTO.getDataDoacao(), doacaoDTO.getIdTurma(), doacaoDTO.getIdAluno(), doacaoDTO.getNomeDoador(), doacaoDTO.getAgencia(), doacaoDTO.getConta()));
		
		if(new MatriculaDao().alterarMontante(doacao)) {
			return Response.status(201).build();

		}
		return Response.status(500).build();

	}
	
	public DoacaoDTO obterDoacaoDTO(String dadosDoacao) {
		return new GsonBuilder().setPrettyPrinting().create().fromJson(dadosDoacao, DoacaoDTO.class);

	}
	
	
	
	
	
	
	
	

}
