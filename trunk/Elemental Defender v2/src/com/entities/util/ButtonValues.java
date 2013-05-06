package com.entities.util;

public enum ButtonValues {
	ATTACKSPEED("Attack Speed", "res/Upgrade/Attack Speed.png"),
	ATTACKDAMAGE("Attack Damage", "res/Upgrade/Attack Damage.png"),
	PARALLELSHOT("Parallel Shot", "res/Upgrade/Parallel Shot.png"),
	TRISHOT("Tri-Shot", "res/Upgrade/Tripple Shot.png"),
	ICESPELL("Ice Spell", "res/Upgrade/Ice Spell.png"),
	LIGHTNINGSPELL("Lightning Spell", "res/Upgrade/Lightning Spell.png"),
	VOLCANOSPELL("Volcano Spell", "res/Upgrade/Volcano Spell.png");
	
	private final String name;
	private final String imgLoc;
	
	private ButtonValues(String title, String location) {
		name = title;
		imgLoc = location;
	}
	
	public String getName(){
		return name;
	}
	
	public String getImgLoc(){
		return imgLoc;
	}
}
