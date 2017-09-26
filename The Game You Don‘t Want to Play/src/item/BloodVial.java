package item;

import character.Player;
/**
 * This class is used to represent the boold vial. It will randomly appear in the map, then player can pick it up into bag.
 *
 * */
public class BloodVial extends ConsumableItem {
	
	private int x,y;
	private int amount = 500; //
	private String type;// small ,big
	private String name = "40";
	public int getAmount() {
		return amount;
	}
	@Override
	public String toString() {
		return name;
	}
    @Override
    public void use(Player player) {
        if(type=="big"){
        
        	player.setHealth(player.getHealth()+amount);
        }else{
        	player.setHealth(player.getHealth()+amount/2);
        }
    	
        this.amount=0;
    }
    
    @Override
    public String getName(){
		return name;
	}
    
    public String getType() {
    		return type;
    }

	public BloodVial(int x, int y, String type){
		this.x =x;
		this.y=y;
		this.type = type;  //either small or big
		if(type.equals("big")) {
			this.name="41";
		}
	}
	@Override
	public boolean on(int x, int y) {
		return this.x==x&&this.y==y;
	}


}
