package item;

import character.Player;

/***
 * This class is used to present the key. The key has different type. The specific type of key could be used to open the corresponding door
 * 
 * Key
 * */

public class Key extends ConsumableItem {
	private int x,y;
    private String name = "KB";
    private String color;
	
	public Key(int x, int y, String color){
	    this.x =x;
	    this.y =y;
	    this.color = color;
    }
	
	public Key(String color) {
		this.color = color;
	}
	
	@Override
	public void use(Player player) {
	}

	@Override
	public boolean on(int x, int y) {
		return false;
	}
	
	public String getName(){
		return name;
	}
	
	public String getColor() {
		return color;
	}

}
