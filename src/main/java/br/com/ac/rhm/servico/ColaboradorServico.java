package br.com.ac.rhm.servico;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.ac.rhm.dao.ColaboradorDao;
import br.com.ac.rhm.dto.ColaboradorDto;
import br.com.ac.rhm.dto.builder.ColaboradorDtoBuilder;
import br.com.ac.rhm.entidades.Colaborador;
import br.org.com.hc.core.dao.DAOGenerico;

public class ColaboradorServico {

	@Inject
	private ColaboradorDao colaboradorDao;
	
	@Inject
	private DAOGenerico<Colaborador, Long> colaboradorDao1;
		
	
	@Inject
	private ColaboradorDtoBuilder colaboradorDtoBuilder;
	
	public List<ColaboradorDto> listarTodos() {
		List<ColaboradorDto> listaPessoaDto = new ArrayList<>();
		
		for (Colaborador pessoa : this.colaboradorDao1.listarTodos("dataNascimento", "nome")) {
			
			ColaboradorDtoBuilder builder = this
					.colaboradorDtoBuilder
					.comIdPessoa(pessoa.getIdColaborador())
					.comNome(pessoa.getNome())
					.comDataNascimento(pessoa.getDataNascimento());
			
			listaPessoaDto.add(builder.construir());	
		}
		return listaPessoaDto;

	}

	public Colaborador incluir(Colaborador colaborador) {
		return this.colaboradorDao.incluir(colaborador);
	}

	public void atualizar(Long idColaborador, Colaborador colaborador) {
		this.colaboradorDao1.atualizar(colaborador);
	}

	public void excluir(Long idColaborador) {
		this.colaboradorDao1.excluir(this.colaboradorDao1.buscarPorId(idColaborador));
	}
}
