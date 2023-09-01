package implementations;

import implementations.LRUWithBuiltInConstruct;

public class LRUWithBuiltInConstructTest {
    public static void main(String[] args) {
        LRUWithBuiltInConstruct lru = new LRUWithBuiltInConstruct(2);
        System.out.println(lru.get(2));
        lru.put(2, 6);
        System.out.println(lru.get(1));
        lru.put(1, 5);
        lru.put(1, 2);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
    }
}
