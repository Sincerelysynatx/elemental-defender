package com.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Enemy extends Entity{
	
	public float health;
	public float damage;
	public float moveSpeed;
	public float attackSpeed;
	public int eleID;
	public boolean state = true;
	private Player player = new Player();
	
	public Enemy(float x, float y, int eleID, float health, float damage, float moveSpeed, float attackSpeed, String imgLoc) throws SlickException {
		super(x, y, imgLoc);
		this.health = health;
		this.damage = damage;
		this.moveSpeed = moveSpeed;
		this.attackSpeed = attackSpeed;
		this.eleID = eleID;
	}
	
	public void damageDone(float damage){
		this.health -= damage;
		if(health <= 0){
			state = false;
		}
	}
	
	public void move(Player mainPlayer){
		if(!this.reachedWall()){
			x = (float) (x - (moveSpeed * .04));
		}else{
			player.takeDamage(this.damage, mainPlayer);
		}
	}
	
	public void update(Player mainPlayer) {
		move(mainPlayer);
	}
	
	public boolean reachedWall(){
		if(x <= 100){
			return true;
		}
		return false;
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException{
		g.drawImage(image, x, y);
		g.drawString(String.format("%.0f", this.health), x + (32 - (9*2)), y + 70f);
		//h.drawHealth(this.health, this.x, this.y + 70f, 1f);
	}
	
	public boolean isOffScreen() {
        if (x < -50) {
            return true;
        } else {
            return false;
        }
    }
	
	public void takeDamage(float damageToDo) {
		this.health -= damageToDo;
		if(this.health <= 0){
			this.state = false;
		}
	}
	
	
	
}
