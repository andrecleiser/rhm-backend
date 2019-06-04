package br.com.ac.rhm.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.ac.rhm.configuracao.LocalDateDeserializer;
import br.com.ac.rhm.configuracao.LocalDateSerializer;
import br.com.ac.rhm.core.dto.DtoBase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ColaboradorDto extends DtoBase {
	
	private static final long serialVersionUID = 8632709066353138055L;
	
	private Long idPessoa;
	
	@JsonSerialize(converter = LocalDateSerializer.class)
	@JsonDeserialize(converter = LocalDateDeserializer.class)
	private LocalDate dataNascimento;
	private String nome;

	public ColaboradorDto(Long idPessoa, LocalDate dataNascimento, String nome) {
		this.idPessoa = idPessoa;
		this.dataNascimento = dataNascimento;
		this.nome = nome;
	}
	
}
