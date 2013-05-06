package com.entities.util;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Mana {
	
	Image pic = null;
	
	public Mana(){
	}
	
	public void drawMana(float health) throws SlickException{
		if(health > 92){
			pic = new Image("res/status/mana/mana_0.png");
			pic.draw(10, 575, 5f);
		}else if(health > 85){
			pic = new Image("res/status/mana/mana_1.png");
			pic.draw(10, 575, 5f);
		}else if(health > 78){
			pic = new Image("res/status/mana/mana_2.png");
			pic.draw(10, 575, 5f);
		}else if(health > 71){
			pic = new Image("res/status/mana/mana_3.png");
			pic.draw(10, 575, 5f);
		}else if(health > 64){
			pic = new Image("res/status/mana/mana_4.png");
			pic.draw(10, 575, 5f);
		}else if(health >57){
			pic = new Image("res/status/mana/mana_5.png");
			pic.draw(10, 575, 5f);
		}else if(health > 50){
			pic = new Image("res/status/mana/mana_6.png");
			pic.draw(10, 575, 5f);
		}else if(health > 43){
			pic = new Image("res/status/mana/mana_7.png");
			pic.draw(10, 575, 5f);
		}else if(health > 35){
			pic = new Image("res/status/mana/mana_8.png");
			pic.draw(10, 575, 5f);
		}else if(health > 28){
			pic = new Image("res/status/mana/mana_9.png");
			pic.draw(10, 575, 5f);
		}else if(health > 21){
			pic = new Image("res/status/mana/mana_10.png");
			pic.draw(10, 575, 5f);
		}else if(health > 14){
			pic = new Image("res/status/mana/mana_12.png");
			pic.draw(10, 575, 5f);
		}else if(health > 7){
			pic = new Image("res/status/mana/mana_13.png");
			pic.draw(10, 575, 5f);
		}else{
			pic = new Image("res/status/mana/mana_14.png");
			pic.draw(10, 575, 5f);
		}
	}
}
