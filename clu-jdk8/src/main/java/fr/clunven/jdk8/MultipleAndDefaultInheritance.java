package fr.clunven.jdk8;

/**
 * JDK8
 *
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public class MultipleAndDefaultInheritance {

    // Interface avec implémentation avec défaut
    public interface A {
        public default void sayHello() {
            System.out.println("Salut");
        }
    }

    // Interface avec implementation par defaut aussi
    public interface B {
        public default void sayHello() {
            System.out.println("Hello");
        }
    }

    // J'implemente A et B, je DOIS indiquer l'implémentatino par defaut
    public class C implements A, B {
        /** {@inheritDoc} */
        @Override
        public void sayHello() {
            A.super.sayHello();
        }
    }

}
