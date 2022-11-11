package gg.jettyrs.services;

import java.util.List;

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

import gg.jettyrs.models.Lembrete;
import gg.jettyrs.repositories.LembreteRepository;

@Path("/lembrete")
public class LembreteService {

	private LembreteRepository lembreteRepository = new LembreteRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Lembrete> getAll(){
		return lembreteRepository.getAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getById(@PathParam("id") long id) {
		Lembrete lembrete;
		if(!lembreteRepository.exists(id)) {
			return Response.status(Response.Status.BAD_REQUEST).entity(id +" Doesn't exist").build();			
		}
		
		lembrete = lembreteRepository.getbyId(id);
		return Response.ok().entity(lembrete).build();
		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(Lembrete lembrete) {
		Lembrete lreturn =  lembreteRepository.insert(lembrete);
		
		return Response.ok().entity(lreturn).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Lembrete lembrete) {
		if(!lembreteRepository.exists(lembrete.getId())) {
			return Response.status(Response.Status.BAD_REQUEST).entity(lembrete.getId()+" Doesn't exists").build();
		}
		
		Lembrete lreturn = lembreteRepository.update(lembrete);
				
		return Response.ok().entity(lreturn).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") long id) {
		if(!lembreteRepository.exists(id)) {
			return Response.status(Response.Status.BAD_REQUEST).entity(id +" Doesn't exist").build();			
		}
		
		lembreteRepository.delete(id);
		
		return Response.ok().entity("Item deleted sucessfully").build();
	}
	
	
}
