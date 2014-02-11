package fr.clun.demo.cxf.domain;

import java.util.Collection;

public class Perso {
	
	private String name;
	
	private String race;
	
	private int dexterity;
	
	private int strength;
	
	private Collection < Stuff > equipment;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public Collection<Stuff> getEquipment() {
		return equipment;
	}

	public void setEquipment(Collection<Stuff> equipment) {
		this.equipment = equipment;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getMagic() {
		return magic;
	}

	public void setMagic(int magic) {
		this.magic = magic;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	private int defense;
	
	private int magic;
	
	private int level;
	
}
