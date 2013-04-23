package src.Game;
//hello -Kyle
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;



public class Menu extends BasicGameState{
	
	private Music song;

	public Menu(int state){
		
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		song = new Music("res/ERMAGERD.wav");
		song.loop();
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.drawString("Menu", 350, 180);
		g.drawString("Press Enter to Play", 285, 220); //Use buttons later
		g.drawString("Press Esc to Exit", 292, 240);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input in = gc.getInput();
		if(in.isKeyDown(Input.KEY_ESCAPE)){
			gc.exit();
		}else if(in.isKeyDown(Input.KEY_ENTER)){
			sbg.enterState(1);
		}
	}

	@Override
	public int getID() {
		return 0;
	}

}
