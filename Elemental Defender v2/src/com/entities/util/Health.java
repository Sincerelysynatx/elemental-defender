package com.entities.util;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Health{
	
	Image pic = null;
	
	public Health(){
	}
	
	public void drawHealth(float health, float x, float y, float scale) throws SlickException{
		if(health > 92){
			pic = new Image("res/status/health/health_0.png");
			pic.draw(x, y, scale);
		}else if(health > 85){
			pic = new Image("res/status/health/health_1.png");
			pic.draw(x, y, scale);
		}else if(health > 78){
			pic = new Image("res/status/health/health_2.png");
			pic.draw(x, y, scale);
		}else if(health > 71){
			pic = new Image("res/status/health/health_3.png");
			pic.draw(x, y, scale);
		}else if(health > 64){
			pic = new Image("res/status/health/health_4.png");
			pic.draw(x, y, scale);
		}else if(health >57){
			pic = new Image("res/status/health/health_5.png");
			pic.draw(x, y, scale);
		}else if(health > 50){
			pic = new Image("res/status/health/health_6.png");
			pic.draw(x, y, scale);
		}else if(health > 43){
			pic = new Image("res/status/health/health_7.png");
			pic.draw(x, y, scale);
		}else if(health > 35){
			pic = new Image("res/status/health/health_8.png");
			pic.draw(x, y, scale);
		}else if(health > 28){
			pic = new Image("res/status/health/health_9.png");
			pic.draw(x, y, scale);
		}else if(health > 21){
			pic = new Image("res/status/health/health_x.png");
			pic.draw(x, y, scale);
		}else if(health > 14){
			pic = new Image("res/status/health/health_12.png");
			pic.draw(x, y, scale);
		}else if(health > 7){
			pic = new Image("res/status/health/health_13.png");
			pic.draw(x, y, scale);
		}else{
			pic = new Image("res/status/health/health_14.png");
			pic.draw(x, y, scale);
		}
	}
}
