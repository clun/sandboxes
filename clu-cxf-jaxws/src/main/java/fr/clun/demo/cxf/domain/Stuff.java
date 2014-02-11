package fr.clun.demo.cxf.domain;

import java.util.Collection;

public class Stuff {
	
	private String name;
	
	private String type;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLevelRequired() {
		return levelRequired;
	}

	public void setLevelRequired(int levelRequired) {
		this.levelRequired = levelRequired;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public Collection<String> getEffects() {
		return effects;
	}

	public void setEffects(Collection<String> effects) {
		this.effects = effects;
	}

	private int levelRequired;
	
	private int defense;
	
	private Collection < String > effects;

}
