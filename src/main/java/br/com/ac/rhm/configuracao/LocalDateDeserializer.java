package br.com.ac.rhm.configuracao;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.util.StdConverter;

public class LocalDateDeserializer extends StdConverter<String, LocalDate> {

	@Override
	public LocalDate convert(String value) {
		System.out.println("aqui");
		System.out.println(value);
		return LocalDate.parse(value, LocalDateSerializer.DATE_FORMATTER);
	}
}