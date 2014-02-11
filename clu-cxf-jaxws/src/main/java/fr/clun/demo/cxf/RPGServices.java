package fr.clun.demo.cxf;

import fr.clun.demo.cxf.domain.Perso;
import fr.clun.demo.cxf.domain.Stuff;

/**
 * Exemple d'utilisation du FrontEND 'SIMPLE' (pas d'annotation
 * dans l'interface et l'on peut donner les interfaces au partenaire
 * sans que ce dernier n'est besoin d'ajouter les libraries CXF).
 *
 * @author lunvenc
 */
public interface RPGServices {

	Stuff loot(Perso grosBill);
	
	int levelup(Perso rookie);
	
	int farming(Perso killerFree);
}
