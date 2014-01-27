package fr.clunven.profiler;

import java.io.Serializable;
import java.util.List;

public class Planet implements Serializable {
	
	/** serial pour la classe. */
	private static final long serialVersionUID = 9109093601946586934L;

	/** Exemple attribut Texte. */
	private String name;
	
	/** Exemple d'attributs liste de String. */
	private List < String > continents;
	
	private int radius;
	
	private double temperature;
	
	private List < Double > attListOfDouble;  
}
