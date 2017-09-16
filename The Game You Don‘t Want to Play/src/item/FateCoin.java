package item;

import character.Player;
/***
 * when the fateCoin is used, the player's health is probably either increased or decreased
 * */
public class FateCoin extends ConsumableItem{
    private int x,y;
	private int randomNumber=0;
	private int amount= 100;

	@Override
	public void use(Player player) {

		 randomNumber= (int)(10*Math.random());
		if(randomNumber<5){
			player.setHealth(player.getHealth()-amount);
        }else{
		    player.setHealth(player.getHealth()+amount);
        }
	}

	@Override
	public boolean on(int x, int y) {
		return this.x==x&&this.y==y;
	}
}
