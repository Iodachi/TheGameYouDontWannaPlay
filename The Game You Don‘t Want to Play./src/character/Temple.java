package character;

import java.util.Map;
import main.InvalidMove;

/**
 * A magic temple that boosts player's stats, note the stats will be boosted for free,
 * but player can only choose from one of them and after used the temple will no longer be active.
 * @author stella
 *
 */
public class Temple {
	//a variety of stats that the temple can boost, with the amount it boosts.
	//for example ("health", 10) means increase player's health by 10
	private Map<String, Integer> boosts;
	//the temple can only be used once and after that it will no longer be active
	private boolean isActive = true;

	public Temple(Map<String, Integer> boosts) {
		this.boosts = boosts;
	}

	/**
	 * Player chooses one stat to boost.
	 * @param stats
	 * @param player
	 */
	public <T> void boost(String stats, Player player) {
		int amount = boosts.get(stats);

		if(stats.equals("health")) {
			player.setHealth(player.getHealth() + amount);
		}else if(stats.equals("damage")) {
			player.setDamage(player.getDamage() + amount);
		}else if(stats.equals("defence")) {
			player.setDefence(player.getDefence() + amount);
		}
		
		//temple is no longer active
		isActive = false;
	}
	
	public boolean isActive() {
		return isActive;
	}
}
