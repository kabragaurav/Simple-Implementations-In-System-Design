package implementations;
import java.util.LinkedHashMap;

public class LRUWithBuiltInConstruct {

    private LinkedHashMap<Integer, Integer> cache;
    private int capacity;

    public LRUWithBuiltInConstruct(int capacity) {
        cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int val = -1;

        if (cache.containsKey(key)) {
            val = cache.remove(key);
            cache.put(key, val);
        }

        return val;
    }
    
    public void put(int key, int value) {
        cache.remove(key);

        cache.put(key, value);

        if (cache.size() > capacity) {
            cache.remove(cache.keySet().iterator().next());
        }
    }
}
