package item;


import character.Player;
/**
 * This class is used to represent the armor equipment which the player can put on to increase defence of player
 * @author minpingyang
 * */
public class Armor extends WearableItem {
    private int defence =10;
	private int x,y;
	private boolean isOn=false;
	private String name = "42";
	private int level = 0;
	boolean getIsOn() {
		return isOn;
	}
	public int getDefence() {
		return defence;
	}

	@Override
	public String toString() {
		return name;
	}
	private int cost= 800;
	public int getCost() {return cost;}
	//level could be 0,1,2
	//when level is 0, the name and defence keep as default
	//Otherwise, they will be changed in setAttribute method
	public Armor(int x,int y, int level){
	    this.x =x;
	    this.y= y;
	    this.level=level;
	    setAttribute(level);
    }
	//level could be 0,1,2
	//when level is 0, the name and defence keep as default
	//Otherwise, they will be changed in setAttribute method
	public void setAttribute(int level) {
		switch (level) {
		case 1:
			defence=200;
			name="25";
			break;
		case 2:
			defence=300;
			name="26";
		    break;
		}

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
