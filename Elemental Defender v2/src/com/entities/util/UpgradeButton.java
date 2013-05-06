package com.entities.util;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class UpgradeButton {
	
	float x;
	float y;
	float width;
	float height;
	int pWidth;
	String iconLoc;
	String name;
	String description;
	String price;
	
	public UpgradeButton(){
	}
	
	public UpgradeButton(float x, float y, float width, float height, int pWidth, String iconLoc, String name, String description, String price) throws SlickException{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.pWidth = pWidth;
		this.iconLoc = iconLoc;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public boolean canAfford(int arcaneCrystals){
		if(Integer.parseInt(this.price) <= arcaneCrystals){
			return true;
		}
		return false;
	}
	
	public void draw(Graphics g) throws SlickException{
		drawFrame(g);
		drawIcon(g);
		drawName(g);
		drawPrice(g);
	}
	
	private void drawFrame(Graphics g){
		g.setColor(Color.black);
		g.drawRect(getXCenter(this.x, this.width), this.y, this.width, this.height);
	}
	
	private void drawIcon(Graphics g) throws SlickException{
		g.drawImage(new Image(this.iconLoc), getXCenter(this.x, pWidth), this.y + 3);
	}
	
	private void drawName(Graphics g){
		g.setColor(Color.black);
		g.drawString(this.name, getStringXCenter(this.x, this.name), this.y + 68);
		
	}
	
	private void drawPrice(Graphics g){
		g.setColor(Color.black);
		g.drawString("Price: " + this.price, getStringXCenter(this.x, "Price: " + this.price), this.y + 250);
	}
	
	private float getXCenter(float x, float width){
		return x - (width / 2);
	}
	
	private float getStringXCenter(float x, String str){
		return x - ((str.length() * 9) / 2);
	}
	
	public void checkForBuy(){
		
	}
}
