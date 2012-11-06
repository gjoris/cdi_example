package eu.droidit.example.controller;

import eu.droidit.example.repository.SampleRepository;

import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: geroen
 * Date: 6/11/12
 * Time: 19:59
 * To change this template use File | Settings | File Templates.
 */
public class SampleController {

    @Inject
    @Any
    private SampleRepository repository;

    public Response get() {
        return Response.ok().build();
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

    public Response getList() {
        return Response.ok().entity(repository.getList()).build();
    }
}
