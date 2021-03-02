package lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author djl
 * @create 2021/2/27 8:55
 */
public class SimpleLRU<K, V> extends LinkedHashMap<K, V> {

    private final int max_size;

    public SimpleLRU(int size) {
        super((int) Math.ceil(size / 0.75) + 1, (float) 0.75, true);
        this.max_size = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > max_size;
    }
}
