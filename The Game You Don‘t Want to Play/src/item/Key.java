package item;

import character.Player;

/***
 * This class is used to present the key. The key has different type. The specific type of key could be used to open the corresponding door
 * 
 * Key
 * */

public class Key extends ConsumableItem {
	private int x,y;
    private String name = "30";
    private String color;
	
	public Key(int x, int y, String color){
	    this.x =x;
	    this.y =y;
	    this.color = color;
	    generateName(color);
    }
	@Override
	public String toString() {
		return name;
	}
	
	public void generateName(String color) {
		switch (color) {
		case "gold":
			name= "30";
			break;
		case "silver":
			name= "34";
			break;
		case "purple":
			name="33";
			break;
		case "cyan":
			name="31";
			break;
		case "bronze":
			name="32";
			break;
		}
	}
		
	public Key(String color) {
		this.color = color;
		generateName(color);
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
