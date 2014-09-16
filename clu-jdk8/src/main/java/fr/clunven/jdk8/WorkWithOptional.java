package fr.clunven.jdk8;

import java.util.Optional;

import org.junit.Test;

public class WorkWithOptional {

    public void displayIfnotNull(String s) {
        Optional.ofNullable(s).ifPresent(System.out::print);
    }
    
    @Test
    public void testOptional() {
        displayIfnotNull("toto");
        displayIfnotNull(null);
    }
    
    public static void main(String[] args) {
        // Optional
        String p = null;
        Optional<String> opt = Optional.ofNullable(p);
        opt.map(String::trim).filter(t -> t.length() > 1).ifPresent(System.out::print);
    }
}
