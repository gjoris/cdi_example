package eu.droidit.example.controller;

import com.google.common.collect.Maps;
import eu.droidit.example.repository.SampleRepository;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.ServletException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.IOException;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
    private SampleRepository repository;

    private final String message = "My Little String";
    private final int id = 1;

    @Before
    public void setUp() {

    }

    @Test
    @Ignore
    public void testGet() throws IOException, ServletException {
        //no need to test the get, simple forward
    }

    @Test
    public void testGetList() {
        Map<Integer, String> mockedMap = Maps.newHashMap();
        when(repository.getMap()).thenReturn(mockedMap);

        Response response = controller.getMap();

        assertThat(response.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
        verify(repository).getMap();
        assertThat(response.getEntity()).isInstanceOf(StreamingOutput.class);
    }

    @Test
    public void testPost() {
        //Response response = controller.post("message");
        Response response = controller.post();

        assertThat(response.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
        verify(repository).add(message);
    }

    @Test
    public void testPut() {
        Response response = controller.put(message);

        assertThat(response.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
        verify(repository).add(message);
    }

    @Test
    public void testDeleteSucceeded() {
        when(repository.deleteById(id)).thenReturn(true);

        Response response = controller.delete(id);

        assertThat(response.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
    }

    @Test
    public void testDeleteFailed() {
        when(repository.deleteById(id)).thenReturn(false);

        Response response = controller.delete(id);

        assertThat(response.getStatus()).isEqualTo(Response.Status.NOT_MODIFIED.getStatusCode());
    }

}
