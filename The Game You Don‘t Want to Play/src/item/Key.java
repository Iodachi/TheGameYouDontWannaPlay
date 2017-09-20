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
			break;
		case CyanKey:
			name="KC";
			break;
		case BronzeKey:
			name="KB";
			break;
		case PurplyeKey:
			name="KP";
			break;
		case SilverKey:
			name="KS";
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
}
