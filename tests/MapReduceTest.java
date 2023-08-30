package tests;

import java.util.List;
import java.util.Map;

import implementations.MapReduce;

/**
 * Simple test for MapReduce.java class
 * 
 * @author gaurav kabra
 * @since Aug 2023
 */
public class MapReduceTest {
    public static void main(String[] args) {
        String document = """
                This is a Map-Reduce program test.
                I am main method. 
                Although I am just a method, I am special.
            """;
        
        List<Map<String, Integer>> mappings = MapReduce.map(document);
        MapReduce.sort(mappings);
        // OUTPUT: {=1, Although=1, I=3, Map-Reduce=1, This=1, a=2, am=3, is=1, just=1, main=1, method,=1, method.=1, program=1, special.=1, test.=1}
        System.out.println(MapReduce.reduce(mappings));
    }
}
