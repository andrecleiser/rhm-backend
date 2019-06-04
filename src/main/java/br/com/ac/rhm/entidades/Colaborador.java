package br.com.ac.rhm.entidades;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.ac.rhm.configuracao.LocalDateDeserializer;
import lombok.Data;

@Entity
@Table(name="colaborador")
@Data
public class Colaborador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_colaborador")
	private Long idColaborador;

	@NotNull(message = "O nome do colaborador tem que ser informado")
	@Size(max = 50, message = "O nome do colaborador não pode ter mais do que 50 caracteres")
	private String nome;
	
	@NotNull
	@Past(message = "A data de nascimento não pode ser futura")
	@Column(name = "data_nascimento")
	@JsonDeserialize(converter = LocalDateDeserializer.class)
	private LocalDate dataNascimento;
	
	@NotNull
	@Size(max = 50, min = 10)
	private String email;
	
	@Size(max = 11, min = 11)
	private String celular;
}
