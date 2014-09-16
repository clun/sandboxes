package fr.clunven.sample;

import java.util.function.Predicate;

import fr.clunven.jdk8.lambda.MyLambdaInterface;

public class SamplePredicateFeature {

    Predicate<String> check = (s) -> {
        return (s.length() > 0);
    };
    
    Predicate<String> check2 = (s) -> s.length() > 0;

    MyLambdaInterface myLambda = (a, b) -> a + b;

}
