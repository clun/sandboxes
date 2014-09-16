package fr.clunven.jdk8.lambda;

import java.util.function.Consumer;

public interface MyConsumer extends Consumer < String > {
    
    public default void accept(String a) {
        System.out.println("Accept " + a);
    }

}
