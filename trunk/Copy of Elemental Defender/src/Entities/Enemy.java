package src.Entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public abstract class Enemy extends Entity{
	public float damage;
	public float moveSpeed;
	public float attackSpeed;
	public float health;
	public int eleID;
	public boolean state = true;
	
	public Enemy(float x, float y, String imgLoc, float damage, float moveSpeed, float attackSpeed, float health, int eleID) throws SlickException {
		super(x, y, imgLoc);
		this.damage = damage;
		this.moveSpeed = moveSpeed;
		this.attackSpeed = attackSpeed;
		this.health = health;
		this.eleID = eleID;
	}
	
	public void doDamage(float damage){
		if(this.reachedWall()){
			
		}
	}
	
	public void damageDone(float damage){
		this.health -= damage;
		if(health <= 0){
			state = false;
		}
	}
	
	public void move(){
		if(!this.reachedWall()){
			x = (float) (x - (moveSpeed * .04));
		}
	}
	
	public boolean reachedWall(){
		if(x <= 50){
			return true;
		}
		return false;
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException{
		g.drawImage(image, x, y);
		g.drawString(String.valueOf(health), x, y + 15f);
	}

	public void update() {
		move();
	}
	
	public boolean isOffScreen() {
        if (x < -50) {
            return true;
        } else {
            return false;
        }
    }
	
}
