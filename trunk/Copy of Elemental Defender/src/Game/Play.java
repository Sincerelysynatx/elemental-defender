package src.Game;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import Entities.Enemy;
import Entities.Player;
import Entities.Projectile;

public class Play extends BasicGameState{
	
	Player plr;
	Music song;
	ArrayList<Enemy> enemy = new ArrayList();
	ArrayList<Projectile> projectile = new ArrayList();
	
	public Play(int state){
		
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		//song = new Music("res/test_theme.wav");
		//song.loop();
		plr = new Player(50f, 200f, "res/test.png", 1.f, 65.f);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		plr.render(gc, sbg, g);
		RenderEntities(gc, sbg, g);
	}

	private void RenderEntities(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		for(Enemy tempEnemy : enemy){
			tempEnemy.render(gc, sbg, g);
		}
		
		for(Projectile tempProjectile : projectile){
			tempProjectile.render(gc, sbg, g);
		}
		
	}
	
	public void spawnEnemy(int numberToSpawn) throws SlickException{
		Random r = new Random();
		for(int i = 0; i <= numberToSpawn; i++){
			float x = r.nextFloat() * 850;
			float y = r.nextFloat() * 460;
		}
	}
	
	public void UpdateEntities(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        for (int i = 0; i < enemy.size() - 1; i++) {
            enemy.get(i).update();
            if (enemy.get(i).isOffScreen()) {
                enemy.remove(i);
            }
            if (enemy.get(i).state == false) {
                enemy.remove(i);
            }
        }
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input in = gc.getInput();
		if(in.isKeyDown(Input.KEY_P)){
			sbg.enterState(0);
		}else if(in.isKeyDown(Input.KEY_U)){
			sbg.enterState(2);
		}
		plr.update(gc, sbg, delta, projectile);
        UpdateEntities(gc, sbg, delta);
	}

	@Override
	public int getID() {
		return 1;
	}

}
