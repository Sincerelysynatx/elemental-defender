package com.entities;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class Projectile extends Entity{
	
	private boolean state;
	private float damage;
	private float rotation;
	private float speed;
	
	public Projectile(float x, float y, String imgLoc, boolean state, float damage, float rotation, float speed) throws SlickException {
		super(x, y, imgLoc);
		this.setState(state);
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
				currentEnemy.takeDamage(damage);
				return true;
			}
		}
		return false;
	}
	
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException{
		g.drawImage(image, x, y);
	}
	
	public boolean isOffScreen() {
        if (x > 1200 || x < -50) {
            return true;
        } else {
            return false;
        }
	}

	public void update(int delta) {
		move();
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}
