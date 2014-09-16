package fr.clunven.sample;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    
    public Main() {

        List<String> features = new ArrayList<String>();

        // For Each
        features.forEach(s -> s.toUpperCase());
        
        // Tri sur la longueur
        features.sort(comparing(p -> p.length()));

        // Idem faster
        features.sort(comparing(String::length));

        // String list values
        features.sort(naturalOrder());


        // Optional
        String p = null;
        Optional<String> opt = Optional.ofNullable(p);
        opt.map(String::trim).filter(t -> t.length() > 1).ifPresent(System.out::print);

        Optional<String> firstName = Optional.of("Tom");
        System.out.println("First Name is set? " + firstName.isPresent());
        System.out.println("First Name: " + firstName.orElseGet(() -> "[none]"));
        System.out.println(firstName.map(s -> "Hey " + s + "!").orElse("Hey Stranger!"));
        System.out.println();

    }

}
