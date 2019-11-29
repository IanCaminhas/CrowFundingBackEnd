package br.com.crowfunding.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.crowfunding.dao.EnderecoDao;
import br.com.crowfunding.dao.InstituicaoDao;
import br.com.crowfunding.dto.InstituicaoDTO;
import br.com.crowfunding.dto.UsuarioDTO;
import br.com.crowfunding.enums.Arquivo;
import br.com.crowfunding.model.Endereco;
import br.com.crowfunding.model.Instituicao;
import br.com.crowfunding.repository.ArquivoRepository;

@Path("instituicoes")
public class InstituicaoResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("cadastrar")
	public Response cadastrarInstituicao(String dadosInstituicao) {
		
		InstituicaoDTO instituicaoDTO = this.dtoParaInstituicao(dadosInstituicao);
		
		if(!new ArquivoRepository(Arquivo.INSTITUICAO).isArquivoVazio()) {
			if (new InstituicaoDao().verifcaEmailExistente(instituicaoDTO.getEmail())) {
				return Response.status(404).build();
			}
		}
		
		
		Endereco endereco = new EnderecoDao().adiciona(instituicaoDTO.getRua(), instituicaoDTO.getBairro(),
				instituicaoDTO.getNumeroPropriedade(), instituicaoDTO.getComplemento(), instituicaoDTO.getLogradouro());

		Instituicao instituicao = new Instituicao(instituicaoDTO.getNome(), instituicaoDTO.getCnpj(),
				instituicaoDTO.getTelefone(), instituicaoDTO.getEmail(), instituicaoDTO.getResponsavel(),
				instituicaoDTO.getDescricao(), instituicaoDTO.getConta(), instituicaoDTO.getAgencia(),
				instituicaoDTO.getSenha(), endereco.getId());

		instituicao = new InstituicaoDao().adiciona(instituicao);

		instituicaoDTO.setId(instituicao.getId());

		return Response.ok(new Gson().toJson(instituicaoDTO)).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("login")
	public Response login(String credenciais) {

		UsuarioDTO user = new GsonBuilder().setPrettyPrinting().create().fromJson(credenciais, UsuarioDTO.class);

		InstituicaoDTO instituicaoDTO = new InstituicaoDao().validaCredenciais(user);

		if (instituicaoDTO.equals(null)) {
			return Response.status(404).build();
		}

		return Response.ok(new Gson().toJson(instituicaoDTO)).build();
	}

	private InstituicaoDTO dtoParaInstituicao(String conteudo) {
		return new GsonBuilder().setPrettyPrinting().create().fromJson(conteudo, InstituicaoDTO.class);
	}

	

}
