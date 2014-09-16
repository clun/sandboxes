package fr.clunven.sample;

public interface StaticMethodInterface {

    static int create(String supplier) {
        return supplier.length();

    }

}
