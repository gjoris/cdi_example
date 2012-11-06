package eu.droidit.example.controller;

import eu.droidit.example.repository.DummyRepository;import eu.droidit.example.repository.SampleRespository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.internal.util.reflection.Whitebox.setInternalState;

/**
 * Created with IntelliJ IDEA.
 * User: geroen
 * Date: 6/11/12
 * Time: 20:00
 * To change this template use File | Settings | File Templates.
 */
@RunWith(MockitoJUnitRunner.class)
public class SampleControllerTest {

    @InjectMocks
    private SampleController controller = new SampleController();

    @Mock
    private SampleRespository repository;

    @Before
    public void setUp() {
    }

    @Test
    public void testGet() {
        Response response = controller.get();

        assertThat(response.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
    }

    @Test
    public void testPost() {
        Response response = controller.post("My Little String");

        assertThat(response.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
    }

}
