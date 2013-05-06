package src.com.game;

public class Level {
	
	Play play;
	int level;
	
	public Level(int level){
		this.level = level;
		play = new Play();
	}
	
	public int updateLevel(){
		return this.level++;
	}
	
	public float getEleDamage(float damage){
		return (float) Math.pow(1.0525, level);
	}
	
	public void endSpawn(){
		if(Play.numOfEnemies >= (int) Math.pow(1.105, level) + 10){
		}
	}
	
	public int getLevel(){
		return this.level;
	}
}
