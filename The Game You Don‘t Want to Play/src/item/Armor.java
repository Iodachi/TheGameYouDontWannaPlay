package item;

import character.Player;
/**
 * This class is used to represent the armor equipment which the player can put on to increase defence of player
 * @author minpingyang
 * */
public class Armor extends WearableItem {
    private int defence =500;
	private int x,y;
	private boolean isOn=false;
	private String name = "armor";

	public Armor(int x,int y){
	    this.x =x;
	    this.y= y;
    }
	public String getName(){
		return name;
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
