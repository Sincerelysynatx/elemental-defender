package src.Entities;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Projectile extends Entity{
	
	public boolean state;
	public float damage;
	public float rotation;
	public float speed;
	
	public Projectile(float x, float y, String imgLoc, boolean state, float damage, float rotation, float speed) throws SlickException {
		super(x, y, imgLoc);
		this.state = state;
		this.damage = damage;
		this.rotation = rotation;
		this.speed = speed;
	}
	
	public void move(){
		x += speed * 0.04f * Math.sin(Math.toRadians(rotation));
        y -= speed * 0.04f * Math.cos(Math.toRadians(rotation));
	}
	
	public boolean collision(ArrayList<Enemy> enemy){
		for(Enemy currentEnemy : enemy){
			if(this.CollidedWith(currentEnemy)){
				currentEnemy.doDamage(damage);
				return true;
			}
		}
		return false;
	}
	
	public void doDamage(float damage){
		
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException{
		g.drawImage(image, x, y);
	}
	
}
