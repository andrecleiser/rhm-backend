package br.com.ac.rhm.api;

import java.net.URI;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.ac.rhm.entidades.Colaborador;
import br.com.ac.rhm.servico.ColaboradorServico;

@Path(ColaboradorApi.URI_BASE)
@ValidateOnExecution
public class ColaboradorApi {

	public static final String URI_BASE = "colaboradores"; 
	
	@Inject
	private ColaboradorServico colaboradorServico;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarTodas() {
		return Response.ok().entity(this.colaboradorServico.listarTodos()).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inclur(Colaborador colaborador) {
		Colaborador novoColaborado = this.colaboradorServico.incluir(colaborador);
		URI uri = URI.create(URI_BASE + "/" + novoColaborado.getIdColaborador().toString());
		return Response.created(uri).build();
	}
	
	@PUT
	@Path("{idColaborador}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam(value = "idColaborador") Long idColaborador, @Valid Colaborador colaborador) {
		
		this.colaboradorServico.atualizar(idColaborador, colaborador);
		return Response.accepted().build();
	}
	
	@DELETE
	@Path("{idColaborador}")
	public Response excluir(@PathParam(value = "idColaborador") Long idColaborador) {
		this.colaboradorServico.excluir(idColaborador);
		return Response.noContent().build();
	}
}
