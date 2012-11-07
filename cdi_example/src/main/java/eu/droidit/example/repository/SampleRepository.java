package eu.droidit.example.repository;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: geroen
 * Date: 6/11/12
 * Time: 20:53
 * To change this template use File | Settings | File Templates.
 */
public interface SampleRepository {
    boolean add(String message);

    boolean deleteById(int id);

    Map<Integer, String> getMap();
}
