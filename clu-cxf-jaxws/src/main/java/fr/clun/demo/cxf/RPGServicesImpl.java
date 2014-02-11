package fr.clun.demo.cxf;

import fr.clun.demo.cxf.domain.Perso;
import fr.clun.demo.cxf.domain.Stuff;

public class RPGServicesImpl implements RPGServices {

	/* (non-Javadoc)
	 * @see fr.clun.demo.cxf.RPGServices#farming(fr.clun.demo.cxf.domain.Perso)
	 */
	public int farming(Perso killerFree) {
		int nbMonsters = (int) Math.random();
		int xp = nbMonsters * 1000 * killerFree.getLevel();
		return xp;
	}

	/* (non-Javadoc)
	 * @see fr.clun.demo.cxf.RPGServices#levelup(fr.clun.demo.cxf.domain.Perso)
	 */
	public int levelup(Perso rookie) {
		return rookie.getLevel() + 1;
	}

	/* (non-Javadoc)
	 * @see fr.clun.demo.cxf.RPGServices#loot(fr.clun.demo.cxf.domain.Perso)
	 */
	public Stuff loot(Perso grosBill) {
		Stuff newStuff = new Stuff();
		newStuff.setName("Mysterious Bow");
		newStuff.setLevelRequired(grosBill.getLevel() - 1);
		newStuff.setDefense(grosBill.getDefense() + 3);
		return newStuff;
	}

}
