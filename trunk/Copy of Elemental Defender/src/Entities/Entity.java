package src.Entities;

import java.awt.Rectangle;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Entity {
	public float x;
	public float y;
	public Image image;
	public float height;
	public float width;
	
	public Entity(float x, float y, String imgLoc) throws SlickException{
		this.x = x;
		this.y = y;
		this.image = new Image(imgLoc);
		this.height = this.image.getHeight();
		this.width = this.image.getWidth();
	}
	
	public boolean CollidedWith(Enemy currentEnemy){
		Rectangle myRect = new Rectangle((int)x,(int)y,(int)width,(int)height);
        Rectangle otherRect = new Rectangle((int)currentEnemy.x,(int)currentEnemy.y,(int)currentEnemy.width,(int)currentEnemy.height);
        if(myRect.intersects(otherRect)){
            return true;
        }else{
            return false;
        }
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawImage(image, x, y);
	}
	
}
