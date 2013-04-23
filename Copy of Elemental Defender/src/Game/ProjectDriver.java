package src.Game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class ProjectDriver extends StateBasedGame {
	
	public static final String gamename = "Elemental Defender";
	
	public static final int menu = 0;
	public static final int play = 1;
	public static final int upgrade = 2;
	
	public ProjectDriver(String gamename){
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new Upgrade(upgrade));
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(upgrade).init(gc, this);
		this.enterState(menu);
	}
	
	public static void main(String[] args){
		AppGameContainer appgc;
		try{
			appgc = new AppGameContainer(new ProjectDriver(gamename));
			appgc.setDisplayMode(760, 520, false);
			appgc.setShowFPS(false);
			appgc.start();
		}catch(SlickException e){
			e.printStackTrace();
		}
	}
	
}
