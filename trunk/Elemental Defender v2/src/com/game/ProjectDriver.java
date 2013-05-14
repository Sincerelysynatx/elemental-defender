

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class ProjectDriver extends StateBasedGame {
	
	public static final String gamename = "Elemental Fortress";
	
	public static final int menu = 0;
	public static final int play = 1;
	public static final int upgrade = 2;
	public static final int gameover = 3;
	
	public ProjectDriver(String gamename){
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
		this.addState(new Upgrade(upgrade));
		this.addState(new GameOver(gameover));
	}

	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(upgrade).init(gc, this);
		this.getState(gameover).init(gc, this);
		this.enterState(menu);
		
	}
	
	public static void main(String[] args){
		AppGameContainer appgc;
		try{
			appgc = new AppGameContainer(new ProjectDriver(gamename));
			appgc.setDisplayMode(1200, 600, false);
			appgc.setShowFPS(true);
			appgc.setTargetFrameRate(60);
			appgc.start();
		}catch(SlickException e){
			e.printStackTrace();
		}
	}
	
}
