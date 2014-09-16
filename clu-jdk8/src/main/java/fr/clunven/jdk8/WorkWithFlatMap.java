package fr.clunven.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

public class WorkWithFlatMap {

    @Test
    public void testConcat() {
        Stream<List<Integer>> integerListStream = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5));
        Stream<Integer> integerStream = integerListStream.flatMap((integerList) -> integerList.stream());
        integerStream.forEach(System.out::println);
    }
    
    @Test
    public void testNestedLoop() {
        IntStream sequence = IntStream.rangeClosed(1, 4).flatMap(i -> IntStream.iterate(i, IntUnaryOperator.identity()).limit(i));
        sequence.forEach(System.out::println);
    }
}
