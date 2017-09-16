package item;

import character.Player;

public class Armor extends WearableItem {
    private int defence =500;
	private int x,y;
	private boolean isOn=false;


	public Armor(int x,int y){
	    this.x =x;
	    this.y= y;
    }
	@Override
	public boolean on(int x, int y) {
		return this.x ==x&&this.y==y;
	}

	@Override
	public void putOn(Player player) {
	  if(!isOn){
          player.setDefence(player.getDefence()+defence);
          isOn=true;
      }

	}

    @Override
    public void takeOff(Player player) {
	    if(isOn){
            player.setDefence(player.getDefence()-defence);
            isOn=false;
        }

    }



	@Override
	public void fix(int amount) {

	}
}
