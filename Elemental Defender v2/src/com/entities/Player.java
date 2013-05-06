package com.entities;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Player extends Entity{
	private Input input;
	private float attackSpeed;
	private float rotation;
	private float cooldown;
	private float health;
	private float mana;
	
	public Player(){
		
	}
	
	public Player(float x, float y, String imgLoc, float attackSpeed, float health, float mana) throws SlickException {
		super(x, y, imgLoc);
		this.setAttackSpeed(attackSpeed);
		this.health = health;
		this.mana = mana;
	}
	
	public void setRotation(Input in){
		float mXD = (float) (in.getMouseX() - x - width/2);
        float mYD = (float) (in.getMouseY() - y - height/2);

        rotation = (float) Math.toDegrees(Math.atan(mYD / mXD));

        if (mXD < 0) {
            rotation += 180;
        }
        image.setRotation(rotation);
	}
	
	public float getRotation(Input in){
		float mXD = (float) (in.getMouseX() - x - width/2);
        float mYD = (float) (in.getMouseY() - y - height/2);

        rotation = (float) Math.toDegrees(Math.atan(mYD / mXD));

        if (mXD < 0) {
            rotation += 180;
        }
        return rotation;
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta, ArrayList<Projectile> projectiles){
		input = gc.getInput();
        setRotation(input);        
        setCooldown(getCooldown() + 1);
	}
	
	public void takeDamage(float damage, Player player){
		player.health -= damage;
	}
	
	public float getHealth(){
		return health;
	}
	
	public float getMana(){
		return mana;
	}
	
	public boolean isDead(Player mainPlayer){
		if(mainPlayer.health >= 0){
			return true;
		}
		return false;
	}

	public float getAttackSpeed() {
		return attackSpeed;
	}

	public void setAttackSpeed(float attackSpeed) {
		this.attackSpeed = attackSpeed;
	}

	public float getCooldown() {
		return cooldown;
	}

	public void setCooldown(float cooldown) {
		this.cooldown = cooldown;
	}
	
	public void addMana(float mana){
		this.mana += mana;
	}
	
	public void subMana(float mana){
		this.mana -= mana;
	}
}
