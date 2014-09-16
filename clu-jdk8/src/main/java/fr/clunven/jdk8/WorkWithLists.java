package fr.clunven.jdk8;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;

import java.util.ArrayList;
import java.util.List;

public class WorkWithLists {
    
    public static void main(String[] args) {
        // une liste de String
        List<String> features = new ArrayList<String>();

        // For Each
        if (features != null) {
            features.forEach(s -> s.toUpperCase());
        }
        
        // Tri sur la longueur
        features.sort(comparing(p -> p.length()));

        // Idem faster
        features.sort(comparing(String::length));

        // String list values
        features.sort(naturalOrder());
    }

}
