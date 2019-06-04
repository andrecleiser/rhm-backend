package br.com.ac.rhm.api.exception;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.ac.rhm.core.excecao.ValidacaoParametrosApiErro;

@Provider
public class MyExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		System.out.println("Validator");
		return Response.status(Response.Status.BAD_REQUEST)
				.entity(prepareMessage(exception))
				.type("application/json")
				.build();
	}
	
	 private List<ValidacaoParametrosApiErro> prepareMessage(ConstraintViolationException exception) {
	      List<ValidacaoParametrosApiErro> listaDeErros = new ArrayList<>();
	      
	      for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
	    	  listaDeErros.add(new ValidacaoParametrosApiErro(cv.getPropertyPath().toString(), cv.getMessage()));
	      }
	      return listaDeErros;
	  }	

}