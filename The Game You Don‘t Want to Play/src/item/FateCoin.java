package item;

import character.Player;
/***
 *This class is used to represent the a lucky coin item
 * when the fate coin is used, the player's health is randomly either increased or decreased.
 * */
public class FateCoin extends ConsumableItem{
    private int x,y;
	private int randomNumber=0;
	private int amount= 100;
	private String name="53";
	private int cost= 80;
	public int getCost() {return cost;}
    public FateCoin(int x, int y) {
    	this.x =x;
    	this.y=y;
    }
    public int getRandomNumber() {
		return randomNumber;
	}
    public int getAmount() {
		return amount;
	}
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
	@Override
	public String getName(){
		return name;
	}
}
