package item;

import character.Player;

/***
 * This class is used to present the key. The key has different type. The specific type of key could be used to open the corresponding door
 * 
 * Key
 * */

public class Key extends ConsumableItem {
	private int x,y;
    private KeyType type=KeyType.GoldKey; // the key type is corresponding to the type of door.
    private String name = "KB";
    private String color;
    private int cost= 60;
	public int getCost() {return cost;}
	public Key(int x, int y, KeyType type){
	    this.x =x;
	    this.y =y;
	    this.type=type;
	    setName(type);
    }
	public enum KeyType{
		GoldKey,CyanKey,BronzeKey,PurplyeKey,SilverKey;
	};
	
	public void setName(KeyType type){
		
		switch (type) {
		case GoldKey:
			name="KG";
			cost =0;
			cost = 240;
			break;
		case CyanKey:
			name="KC";
			cost = 480;
			break;
		case BronzeKey:
			name="KB";
			cost = 60;
			break;
		case PurplyeKey:
			name="KP";
			cost = 1360;
			break;
		case SilverKey:
			name="KS";
			cost = 120;
			break;
		}
	}
	
	public KeyType getType(){
		return type;
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
