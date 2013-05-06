package src.com.game;

import java.util.ArrayList;

import com.entities.util.UpgradeButton;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.*;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class Upgrade extends BasicGameState{
	
	Music song;
	Image background = null;
	Input in;
	ArrayList<UpgradeButton> button;
	final String TITLE = "Shop";
	final String ATKSPD = "Attack Speed";
	final String ATKDMG = "Attack Damage";
	final String ICESPL = "Ice Spell";
	final String VCOSPL = "Volcano Spell";
	final String LGTSPL = "Lightning Spell";
	final String PRLSHT = "Parallel Shot";
	final String TRISHT = "Tri-Shot";
	final String HEALTH = "Health";	
	
	public Upgrade(){
	}
	
	public Upgrade(int state){}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		background = new Image("res/upgrade/shp_wnd.png");
		in = gc.getInput();
		song = new Music("res/music/shop_theme.wav");
		initButtons();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setColor(Color.black);
		background.draw(0, 0);
		drawStringCentered(TITLE, gc, g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		if(in.isKeyDown(Input.KEY_ESCAPE)){
			sbg.enterState(0, new FadeOutTransition(), new FadeInTransition());
		}else if(in.isKeyDown(Input.KEY_U)){
			sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
		}
		
		//button.checkForBuy();
	}

	private void initButtons() throws SlickException{
		
		button.add(new UpgradeButton(149.5f , 175f, 140f, 300f, 64, "res/upgrade/atk_dmg.png", ATKDMG, "This will increase attack player damage.", "10"));
		button.add(new UpgradeButton(299f, 175f, 140f, 300f, 64, "res/upgrade/atk_spd.png", ATKSPD, "This will increase attack player damage.", "10"));
		button.add(new UpgradeButton(448.5f, 175f, 140f, 300f, 64, "res/upgrade/hp.png", HEALTH, "This will increase attack player damage.", "10"));
		button.add(new UpgradeButton(598f, 175f, 140f, 300f, 64, "res/upgrade/ice_spl.png", ICESPL, "This will increase attack player damage.", "10"));
		button.add(new UpgradeButton(747.5f, 175f, 140f, 300f, 64, "res/upgrade/lgt_spl.png", LGTSPL, "This will increase attack player damage.", "10"));
		button.add(new UpgradeButton(897f, 175f, 140f, 300f, 64, "res/upgrade/prl_sht.png", PRLSHT, "This will increase attack player damage.", "10"));
		button.add(new UpgradeButton(1046.5f, 175f, 140f, 300f, 64, "res/upgrade/tri_sht.png", TRISHT, "This will increase attack player damage.", "10"));
	
	}
	
	@Override
	public int getID() {
		return 2;
	}

	private void drawStringCentered(String str, GameContainer gc, Graphics g){
		g.drawString(str, (gc.getWidth() / 2) - ((str.length() * 9) / 2), 15);
	}
}
