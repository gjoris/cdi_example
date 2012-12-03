package eu.droidit.example.controller;

import com.sun.jersey.api.view.Viewable;
import eu.droidit.example.repository.SampleRepository;
import eu.droidit.example.repository.SampleRepositoryImpl;
import eu.droidit.example.utils.Forwarder;

import javax.ejb.Stateless;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static eu.droidit.example.utils.Forwarder.forward;

/**
 * Created with IntelliJ IDEA.
 * User: geroen
 * Date: 6/11/12
 * Time: 19:59
 * To change this template use File | Settings | File Templates.
 */
@Stateless
@Path("/")
public class SampleController {

    @Inject
    private SampleRepository repository;

    @GET
    public Viewable get(@Context HttpServletRequest request, @Context HttpServletResponse response) throws URISyntaxException {
        return new Viewable("/index", this);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(String message) {
        repository.add(message);
        return Response.ok().entity("Your message has been posted!").build();
    }

    @PUT
    @Path("{message}")
    public Response put(@PathParam("message") String message) {
        repository.add(message);
        return Response.ok().entity("Your message has been put!").build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") int id) {
        if (repository.deleteById(id)) return Response.ok().entity("Your message has been deleted!").build();
        return Response.notModified().entity("Your message could not be found!").build();
    }

    @GET
    @Path("list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMap() {
        return Response.ok().entity(repository.getMap()).build();
    }
}
