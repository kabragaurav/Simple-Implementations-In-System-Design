package implementations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * A basic implementation of map-reduce functionality
 * 
 * Calculates the frequency of each word in a document
 * 
 * @author gaurav kabra
 * @since Aug 2023
 */
public class MapReduce {
    
    public static List<Map<String, Integer>> map(String document) {
        // split by one or more white spaces
        String[] words = document.split("\\s+");
        List<Map<String, Integer>> mappings = new ArrayList<>();

        Map<String, Integer> mapping;
        for (String word : words) {
            mapping = new HashMap<>();
            mapping.put(word, 1);
            mappings.add(mapping);
        }

        return mappings;
    }

    /**
     * MapReduce makes the guarantee that the input to every reducer is sorted by key. 
     * The process by which the system performs the sort and transfers map outputs to the reducers as inputs is known as the shuffle.
     */
    public static void sort(List<Map<String, Integer>> mappings) {
        Collections.sort(mappings, (m1, m2) -> m1.keySet().iterator().next()
                .compareTo(m2.keySet().iterator().next()));
    }

    public static Map<String, Integer> reduce(List<Map<String, Integer>> mappings) {
        Map<String, Integer> freqMap = new TreeMap<>();

        for (Map<String, Integer> mapping : mappings) {
            String key = mapping.keySet().iterator().next();
            freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
        }

        return freqMap;
    }

}