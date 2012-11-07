package eu.droidit.example.repository;

import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: geroen
 * Date: 6/11/12
 * Time: 20:56
 * To change this template use File | Settings | File Templates.
 */
@Singleton //we need a singleton, because for this implementation, we need state (our hashmap)
public class SampleRepositoryImpl implements SampleRepository {

    private HashMap<Integer, String> keyMap;

    @PostConstruct
    private void init() {
        keyMap = Maps.newHashMap();
    }

    @Override
    public boolean add(String message) {
        return StringUtils.equals(keyMap.put(keyMap.size(), message), message);
    }

    @Override
    public boolean deleteById(int id) {
        if (keyMap.get(id) == keyMap.remove(id)) return true;
        return false;
    }

    @Override
    public Map<Integer, String> getMap() {
        return keyMap;
    }
}
