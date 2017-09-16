package item;

import character.Player;

public class BloodVial extends ConsumableItem {

	private int x,y;
	private int amount = 500; //

    @Override
    public void use(Player player) {
        player.setHealth(player.getHealth()+amount);
        this.amount=0;
    }



	public BloodVial(int x, int y){
		this.x =x;
		this.y=y;

	}
	@Override
	public boolean on(int x, int y) {
		return this.x==x&&this.y==y;
	}


}
