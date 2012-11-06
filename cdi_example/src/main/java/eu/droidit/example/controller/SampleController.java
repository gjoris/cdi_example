package eu.droidit.example.controller;

import eu.droidit.example.repository.SampleRespository;

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
    private SampleRespository repository;

    public Response get() {
        return Response.ok().build();
    }

    public Response post(String message) {
        return Response.ok().build();
    }
}
