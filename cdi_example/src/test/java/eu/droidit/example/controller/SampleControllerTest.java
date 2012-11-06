package eu.droidit.example.controller;

import com.google.common.collect.Lists;
import eu.droidit.example.repository.SampleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.core.Response;

import java.util.List;

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
    public void testGet() {
        Response response = controller.get();

        assertThat(response.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
    }

    @Test
    public void testGetList() {
        List mockedList = Lists.newArrayList();
        when(repository.getList()).thenReturn(mockedList);

        Response response = controller.getList();

        assertThat(response.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
        verify(repository).getList();
        assertThat(response.getEntity()).isEqualTo(mockedList);
    }

    @Test
    public void testPost() {
        Response response = controller.post(message);

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
