package fr.clunven.sample;

public interface SampleVirtualExtension {

    public int test();

    /**
     * Ceci est une implémentation par défaut d'une interface.
     * 
     * @return
     */
    public default int sampleVirtualMethod() {
        return 0;
    }

}
