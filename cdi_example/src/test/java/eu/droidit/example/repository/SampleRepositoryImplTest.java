package eu.droidit.example.repository;

import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.internal.util.reflection.Whitebox.setInternalState;

/**
 * Created with IntelliJ IDEA.
 * User: geroen
 * Date: 6/11/12
 * Time: 21:42
 * To change this template use File | Settings | File Templates.
 */
public class SampleRepositoryImplTest {

    private SampleRepositoryImpl repository = new SampleRepositoryImpl();
    private String message = "test-message";

    private HashMap<Integer, String> captureMap;

    @Before
    public void setUp() throws Exception {
        captureMap = Maps.newHashMap();
        setInternalState(repository, "keyMap", captureMap);
    }

    @Test
    public void testAdd() throws Exception {
        repository.add(message);

        assertThat(captureMap.containsValue(message)).isTrue();
    }

    @Test
    public void testDelete() throws Exception {
        givenMapContainsValue();

        repository.deleteById(0);

        assertThat(captureMap.containsValue(message)).isFalse();
    }

    private void givenMapContainsValue() {
        captureMap.put(0, message);
    }

    @Test
    public void testGetList() {
        givenMapContainsValue();

        Map<Integer, String> map = repository.getMap();

        assertThat(map.size()).isEqualTo(1);
        assertThat(map.get(0)).isEqualTo(message);
    }
}
