package eu.droidit.example.utils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static eu.droidit.example.utils.JspHolder.toJsp;

public class Forwarder {

    private HttpServletRequest request;

    private HttpServletResponse response;

    private Forwarder(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    // Not really builder pattern, but easy access!
    public static Forwarder forward(HttpServletRequest request, HttpServletResponse response) {
        return new Forwarder(request, response);
    }

    public void to(String target) {
        try {
            request.getServletContext().getRequestDispatcher(toJsp(target)).forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException("I hate ServletExceptions!");
        } catch (IOException e) {
            throw new RuntimeException("I hate IOExceptions!");
        }
    }
}