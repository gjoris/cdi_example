package eu.droidit.example.controller;

import com.sun.jersey.api.view.Viewable;
import eu.droidit.example.repository.SampleRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.Map;

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
    public Viewable get() throws URISyntaxException {
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
        final Map<Integer, String> stringMap = repository.getMap();
        StreamingOutput output = new StreamingOutput() {
            @Override
            public void write(OutputStream output) throws IOException, WebApplicationException {
                for (Integer integer : stringMap.keySet()) {
                    output.write((integer + " : " + stringMap.get(integer)).getBytes());
                }
            }
        };
        return Response.ok().entity(output).build();
    }
}
