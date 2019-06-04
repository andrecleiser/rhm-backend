package br.com.ac.rhm.dto.builder;

import java.time.LocalDate;

import br.com.ac.rhm.dto.ColaboradorDto;

public class ColaboradorDtoBuilder {
	
	private Long idPessoa;
	private LocalDate dataNascimento;
	private String nome;

	public ColaboradorDtoBuilder comIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
		return this;
	}
	
	public ColaboradorDtoBuilder comDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
	}
	
	public ColaboradorDtoBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public ColaboradorDto construir() {
		return new ColaboradorDto(this.idPessoa, this.dataNascimento, this.nome);
	}
}
