
package character;


public class Monster {
	private int health,damage,defence,drop,level; 
	private final double factor = 0.7;
	private boolean isDefeated;
	//the potential drop of coins when the monster dies


	public Monster(int level){
		initialize(level);
	}
	//==================================== initialize ========================================================
	private void initialize(int level){
		this.level = level;
		this.isDefeated = false;
		this.health= (int) (100*(level- 90)*factor);
		this.damage= (int) (11*(level- 90)*factor);
		this.defence =(int) (3*(level- 90)*factor);
		//generates a random number of coins drop when monster is defeated
		this.drop = (int)Math.random()*10*(level- 90);
	}

	public void defeated(Player player) {
		isDefeated = true;
		player.setGold(player.getGold() + drop);
	}

	public int getDamage() {
		return damage;
	}

	public int getDefence() {
		return defence;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isDefeated() {
		return isDefeated;
	}

	public String toString() {
		return String.valueOf(this.level);
	}
}

