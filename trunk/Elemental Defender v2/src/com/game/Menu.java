package src.com.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Menu extends BasicGameState{
	
	Music song;
	Input in;
	Play play;
	String title = "Menu";
	String enter = "Press enter to play";
	String esc = "Press esc to exit";

	public Menu(int state){
		try {
			song = new Music("res/music/Somtin.wav");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		in = gc.getInput();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setColor(Color.white);
		g.drawString(title, (gc.getWidth() / 2) - ((title.length() * 9) / 2), 180);
		g.drawString(enter, (gc.getWidth() / 2) - ((enter.length() * 9) / 2), 220); //Use buttons later
		g.drawString(esc, (gc.getWidth() / 2) - ((esc.length() * 9) / 2), 240);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		if(in.isKeyDown(Input.KEY_ESCAPE)){
			gc.exit();
		}else if(in.isKeyDown(Input.KEY_ENTER)){
			sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
		}
	}

	@Override
	public int getID() {
		return 0;
	}
	
	public void startMusic(){
		song.loop();
	}
	
	public void stopMusic(){
		song.stop();
	}
}
