package Enemies;

import org.newdawn.slick.SlickException;

import Entities.Enemy;

public class AirEle extends Enemy{

	public int eleID;
	
	public AirEle(float x, float y, String imgLoc, float damage, float moveSpeed, float attackSpeed, float health, int eleID)
			throws SlickException {
		super(x, y, imgLoc, damage, moveSpeed, attackSpeed, health, eleID);
		this.eleID = eleID;
	}

}
