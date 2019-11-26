package br.com.crowfunding.dao;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.crowfunding.dto.DadosParaDoacaoDTO;
import br.com.crowfunding.dto.MatriculaDoAlunoDTO;
import br.com.crowfunding.dto.MatriculasDaInstituicaoDTO;
import br.com.crowfunding.enums.Arquivo;
import br.com.crowfunding.enums.EstadoMatricula;
import br.com.crowfunding.model.Aluno;
import br.com.crowfunding.model.Curso;
import br.com.crowfunding.model.Doacao;
import br.com.crowfunding.model.Endereco;
import br.com.crowfunding.model.Instituicao;
import br.com.crowfunding.model.Matricula;
import br.com.crowfunding.model.Turma;
import br.com.crowfunding.repository.ArquivoRepository;

public class MatriculaDao {

	private ArquivoRepository repository;

	public MatriculaDao() {
		this.repository = new ArquivoRepository(Arquivo.MATRICULAS);
	}

	public Matricula adiciona(Matricula matricula) {

		Map<String, ArrayList<Matricula>> matriculasMap = this.getMatriculas();

		if (repository.isArquivoVazio() || matriculasMap.get("matriculas") == (null)) {
			matriculasMap = new HashMap<String, ArrayList<Matricula>>();
			matriculasMap.put("matriculas", new ArrayList<Matricula>());
		}

		matriculasMap.get("matriculas").add(matricula);

		persistir(matriculasMap);

		return matricula;

	}

	private void persistir(Map<String, ArrayList<Matricula>> matriculasMap) {
		String jsonListaMatriculas = new GsonBuilder().setPrettyPrinting().create().toJson(matriculasMap);

		try {
			repository.persistirJson(jsonListaMatriculas);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<MatriculasDaInstituicaoDTO> matriculasDaInstituicao(Integer idInstituicao) {

		ArrayList<Matricula> listMatriculas = this.getMatriculas().get("matriculas");
		ArrayList<MatriculasDaInstituicaoDTO> listAlunos = new ArrayList<MatriculasDaInstituicaoDTO>();
		for (int i = 0; i < listMatriculas.size(); i++) {

			Matricula matricula = listMatriculas.get(i);
			Turma turma = new TurmaDao().getTurma(matricula.getIdTurma());
			Curso curso = new CursoDao().getCurso(turma.getIdCurso());
			Instituicao instituicao = new InstituicaoDao().getInstituicao(curso.getIdInstituicao());

			if (instituicao.getId().equals(idInstituicao)) {

				Aluno aluno = new AlunoDao().getAluno(matricula.getIdAluno());
				Endereco enderecoAluno = new EnderecoDao().getEndereco(aluno.getIdEndereco());

				MatriculasDaInstituicaoDTO alunoParaAnaliseDTO = new MatriculasDaInstituicaoDTO(aluno.getNome(),
						curso.getNome(), turma.getHorarioInicio(), turma.getHorarioTermino(), turma.getDataInicio(),
						turma.getPrevisaoTermino(),
						EstadoMatricula.getDescricaoEstadoMatricula(matricula.getEstadoMatricula()), aluno.getId(),
						turma.getId(), enderecoAluno.toString(), aluno.getRendaPerCapita(), aluno.getDescricaoPerfil(),
						curso.getEmenta());
				listAlunos.add(alunoParaAnaliseDTO);
			}

		}

		return listAlunos;
	}
	

	public ArrayList<MatriculaDoAlunoDTO> matriculasDoAluno(Integer idAluno) {

		ArrayList<Matricula> listMatriculas = this.getMatriculas().get("matriculas");
		ArrayList<MatriculaDoAlunoDTO> listMatriculasDoAluno = new ArrayList<MatriculaDoAlunoDTO>();
		for (int i = 0; i < listMatriculas.size(); i++) {

			Matricula matricula = listMatriculas.get(i);
			Turma turma = new TurmaDao().getTurma(matricula.getIdTurma());
			Curso curso = new CursoDao().getCurso(turma.getIdCurso());
			Instituicao instituicao = new InstituicaoDao().getInstituicao(curso.getIdInstituicao());
			if (matricula.getIdAluno().equals(idAluno)) {

				MatriculaDoAlunoDTO matriculaDoAlunoDTO = new MatriculaDoAlunoDTO(curso.getNome(), instituicao.getNome(), EstadoMatricula.getDescricaoEstadoMatricula(matricula.getEstadoMatricula()), turma.getHorarioInicio(), turma.getHorarioTermino(), turma.getDataInicio(), turma.getPrevisaoTermino(), curso.getEmenta(), curso.getValor(), matricula.getMontanteDoacao());
				
				listMatriculasDoAluno.add(matriculaDoAlunoDTO);
			}

		}

		return listMatriculasDoAluno;
	}
	

	public Map<String, ArrayList<Matricula>> getMatriculas() {

		Map<String, ArrayList<Matricula>> matriculasMap = null;

		Type listaMatriculas = new TypeToken<HashMap<String, ArrayList<Matricula>>>() {
		}.getType();

		try {
			matriculasMap = new GsonBuilder().setPrettyPrinting().create().fromJson(repository.recuperarJson(),
					listaMatriculas);

			repository.recuperarJson().close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return matriculasMap;

	}

	public void aprovarAluno(Integer idAluno, Integer idTurma) {

		Map<String, ArrayList<Matricula>> map = this.getMatriculas();
		int size = map.get("matriculas").size();
		

		for (int i = 0; i < size; i++) {
			Matricula matricula = map.get("matriculas").get(i);
			if (matricula.getIdAluno().equals(idAluno) && matricula.getIdTurma().equals(idTurma)) {
				map.get("matriculas").get(i)
						.setEstadoMatricula(EstadoMatricula.getCodEstadoMatricula(EstadoMatricula.APROVADO));				
				this.persistir(map);

				return;
			}

		}

	}
	
	public void reprovarAluno(Integer idAluno, Integer idTurma) {

		Map<String, ArrayList<Matricula>> map = this.getMatriculas();
		int size = map.get("matriculas").size();

		for (int i = 0; i < size; i++) {

			Matricula matricula = map.get("matriculas").get(i);
			if (matricula.getIdAluno().equals(idAluno) && matricula.getIdTurma().equals(idTurma)) {
				map.get("matriculas").get(i)
						.setEstadoMatricula(EstadoMatricula.getCodEstadoMatricula(EstadoMatricula.REPROVADO));
				this.persistir(map);

				return;
			}

		}

	}
	
	


	
	public ArrayList<DadosParaDoacaoDTO> getDadosParaRealizarDoacao() {

		ArrayList<Matricula> listMatriculas = this.getMatriculas().get("matriculas");
		ArrayList<DadosParaDoacaoDTO> listDadosParaDoacao = new ArrayList<DadosParaDoacaoDTO>();

		for (int i = 0; i < listMatriculas.size(); i++) {

			Matricula matricula = listMatriculas.get(i);

			if (matricula.getEstadoMatricula()
					.equals(EstadoMatricula.getCodEstadoMatricula(EstadoMatricula.APROVADO))) {
				Turma turma = new TurmaDao().getTurma(matricula.getIdTurma());
				Curso curso = new CursoDao().getCurso(turma.getIdCurso());
				Instituicao instituicao = new InstituicaoDao().getInstituicao(curso.getIdInstituicao());
				Aluno aluno = new AlunoDao().getAluno(matricula.getIdAluno());

				DadosParaDoacaoDTO dadosParaDoacaoDTO = new DadosParaDoacaoDTO(aluno.getNome(), curso.getNome(),
						aluno.getId(), instituicao.getNome(), turma.getId(), curso.getValor(), matricula.getMontanteDoacao());
				listDadosParaDoacao.add(dadosParaDoacaoDTO);

			}

		}

		return listDadosParaDoacao;
	}

	public boolean alterarMontante(Doacao doacao) {
		Map<String, ArrayList<Matricula>> map = this.getMatriculas();
		int size = map.get("matriculas").size();

		for (int i = 0; i < size; i++) {

			Matricula matricula = map.get("matriculas").get(i);

			if (matricula.getIdAluno().equals(doacao.getIdAluno())
					&& matricula.getIdTurma().equals(doacao.getIdTurma())) {

				final double novoMontanteDoacao = this.getMatriculas().get("matriculas").get(i).getMontanteDoacao()
						+ doacao.getValor();
				map.get("matriculas").get(i).setMontanteDoacao(novoMontanteDoacao);
				;

				this.persistir(map);

				return true;

			}

		}

		return false;

	}

}
