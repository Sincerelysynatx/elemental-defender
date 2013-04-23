package src.Entities;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Player extends Entity{
	
	public float damage;
	public float attackSpeed;
	public float rotation;
	public float cooldown;
	public float health;
	
	public Player(float x, float y, String imgLoc, float damage, float attackSpeed) throws SlickException {
		super(x, y, imgLoc);
		this.damage = damage;
		this.attackSpeed = attackSpeed;
	}
	
	public void getRotation(Input in){
		float mXD = (float) (in.getMouseX() - x - width/2);
        float mYD = (float) (in.getMouseY() - y - height/2);

        rotation = (float) Math.toDegrees(Math.atan(mYD / mXD));

        if (mXD < 0) {
            rotation += 180;
        }
        image.setRotation(rotation);
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta, ArrayList<Projectile> projectiles){
		Input input = gc.getInput();
        
        getRotation(input);
        
        cooldown += .1;
	}
	
}
