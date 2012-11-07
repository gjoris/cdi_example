package eu.droidit.example.controller;

import eu.droidit.example.repository.SampleRepository;
import eu.droidit.example.utils.Forwarder;

import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

import static eu.droidit.example.utils.Forwarder.forward;

/**
 * Created with IntelliJ IDEA.
 * User: geroen
 * Date: 6/11/12
 * Time: 19:59
 * To change this template use File | Settings | File Templates.
 */
@Path("/")
public class SampleController {

    @Inject
    @Any
    private SampleRepository repository;

    @GET
    @Path("/")
    public void get(@Context HttpServletRequest request, @Context HttpServletResponse response) {
        forward(request, response).to("index.jsp");
    }

    public Response post(String message) {
        repository.add(message);
        return Response.ok().entity("Your message has been posted!").build();
    }

    public Response put(String message) {
        repository.add(message);
        return Response.ok().entity("Your message has been put!").build();
    }

    public Response delete(int id) {
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
