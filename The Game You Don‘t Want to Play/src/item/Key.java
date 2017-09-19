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
    private String name = "key";
	public Key(int x, int y, KeyType type){
	    this.x =x;
	    this.y =y;
	    this.type=type;
    }
	public enum KeyType{
		GoldKey,CyanKey,BronzeKey,PurplyeKey,SilverKey;
	};
	
	public void setName(KeyType type){
		
		switch (type) {
		case GoldKey:
			name="GoldKey";
			break;
		case CyanKey:
			name="CyanKey";
			break;
		case BronzeKey:
			name="BronzeKey";
			break;
		case PurplyeKey:
			name="PurplyeKey";
			break;
		case SilverKey:
			name="SilverKey";
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
		setName(type);
		return name;
	}
}
