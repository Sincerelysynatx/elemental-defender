package src.com.game;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import com.entities.Enemy;
import com.entities.Player;
import com.entities.Projectile;
import com.entities.util.Health;
import com.entities.util.Mana;



public class Play extends BasicGameState{
	
	Player plr;
	Upgrade upgrade;
	Health h;
	Mana m;
	Input in;
	Music song;
	ArrayList<Enemy> enemy;
	ArrayList<Projectile> projectile;
	ArrayList<Image> health;
	int enemyTick;
	int manaTick;
	static int numOfEnemies;
	int numOfKilled;
	Random r;
	
	public Play(){
	}
	
	public Play(int state){
	}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		try {
			song = new Music("res/music/ERMAGERD2.wav");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		in = gc.getInput();
		r = new Random();
		enemy = new ArrayList<Enemy>();
		projectile = new ArrayList<Projectile>();
		h = new Health();
		m = new Mana();
		upgrade = new Upgrade();
		plr = new Player(50f, (float)(gc.getHeight() / 2 - 32), "res/sprites/test.png",/*Attack Speed*/ 50f/*original is 100f*/,/*Health*/ 100f/*original is 100f*/, 100f);
		generateNextTick();
		manaTick = 0;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.setColor(Color.white);
		plr.render(gc, sbg, g);
		RenderEntities(gc, sbg, g);
		//g.drawString("Health: " + String.format("%.0f", plr.health), 10, gc.getHeight() - 40);
		g.drawString("Arcane Shards Colected: " + numOfKilled, 120, gc.getHeight() - 20);
		h.drawHealth(plr.getHealth(), 10f, 550f, 5f);
		m.drawMana(plr.getMana());
	}

	private void RenderEntities(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		for(Enemy tempEnemy : enemy){
			tempEnemy.render(gc, sbg, g);
		}
		
		for(Projectile tempProjectile : projectile){
			tempProjectile.render(gc, sbg, g);
		}
		
	}
	
	private void spawnEnemy() throws SlickException{
		float tempY = r.nextFloat() * 510;
		int tempID = r.nextInt(4);
		Enemy tempEnemy = new Enemy(1200f, tempY, tempID,/*Health*/ 100f,/*Damage*/ .01f, /*Speed*/ 90f/*Original is 45f*/,/*Attack Speed*/ 1f, randomeEle(tempID));
		enemy.add(tempEnemy);
	}
	
	private void spawnProjectile() throws SlickException{
		Projectile tempProjectile = new Projectile(plr.x, plr.y, "res/sprites/projectile.png", true, 40f /*original is 50f*/, plr.getRotation(in) + 90f, 300f/*original is 100f*/);
		projectile.add(tempProjectile);
	}
	
	private void spawnFireball() throws SlickException{
		Projectile tempProjectile = new Projectile(plr.x, plr.y, "res/sprites/magic_shot.png", true, 20f /*original is 50f*/, plr.getRotation(in) + 90f, 300f/*original is 100f*/);
		projectile.add(tempProjectile);
	}
	
	public void UpdateEntities(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        for (int i = 0; i < enemy.size() - 1; i++) {
            enemy.get(i).update(plr);
            if (enemy.get(i).state == false) {
                enemy.remove(i);
                numOfKilled++;
            }
        }
        
        for (int i = 0; i < projectile.size(); i++) {
            projectile.get(i).update(delta);
            if(projectile.get(i).collision(enemy)){
                projectile.remove(i);
                break;
            }
            if (projectile.get(i).isOffScreen()) {
                projectile.remove(i);
            }
        }
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
		if(in.isKeyDown(Input.KEY_P)){
			sbg.enterState(0, new FadeOutTransition(), new FadeInTransition());
			
		}else if(in.isKeyDown(Input.KEY_U)){
			sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());	
		}
		
		//==================================Cool Down========================================
		if(in.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) && plr.getCooldown() >= plr.getAttackSpeed()){
			spawnProjectile();
			plr.setCooldown(0f);
		}
		
		if(in.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON) && plr.getMana() >= 0){
			spawnFireball();
			plr.subMana(2);
		}
		
		checkTick(delta);
		if(manaTick <= 200){
			manaTick++;
		}else{
			checkManaTick(delta);
		}
		
		plr.update(gc, sbg, delta, projectile);
		UpdateEntities(gc, sbg, delta);
		
		
		
		
		/*
		if(plr.isDead(plr)){
			sbg.enterState(3);
		}
		*/
	}
	
	private void checkTick(int delta) throws SlickException {
		enemyTick += delta;
		if(enemyTick > 3000){
			enemyTick = 0;
			generateNextTick();
			spawnEnemy();
			numOfEnemies++;
		}	
	}
	
	private void checkManaTick(int delta) throws SlickException {
		manaTick += delta;
		if(plr.getMana() <= 100)
			plr.addMana(.02f);
	}
	private int generateNextTick(){
		return enemyTick = (r.nextInt(6000) - 3000);
	}
	
	public String randomeEle(int tempID) {
		if(tempID == 0){
			return "res/sprites/air.png";
		}else if(tempID == 1){
			return "res/sprites/earth.png";
		}else if(tempID == 2){
			return "res/sprites/fire.png";
		}else{
			return "res/sprites/ice.png";
		}
	}
	
	@Override
	public int getID() {
		return 1;
	}
	
	public void startMusic(){
		song.loop();
	}
}
