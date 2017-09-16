package item;

import character.Player;

/***
 * Key
 * */

public class Key extends ConsumableItem {
	private int x,y;
    private KeyType type;
	public Key(int x, int y, KeyType type){
	    this.x =x;
	    this.y =y;
	    this.type=type;
    }
	public enum KeyType{
		GoldKey,CyanKey,BronzeKey,PurplyeKey,SilverKey;
	};

	@Override
	public void use(Player player) {
	}

	@Override
	public boolean on(int x, int y) {
		return false;
	}
}
