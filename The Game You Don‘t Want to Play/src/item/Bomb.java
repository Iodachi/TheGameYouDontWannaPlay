package item;

import character.Player;

/**
 * This class is used to represent bomb. It is used to destroy the breakable wall
 * Created by minpingyang on 16/09/17.
 */
public class Bomb extends ConsumableItem {
    private int x,y;
    private String name = "bomb";
    public Bomb(int x, int y){
        this.x = x;
        this.y =y;

    }
    @Override
    public boolean on(int x, int y) {
        return false;
    }

    @Override
    public void use(Player player) {

    }
    @Override
    public String getName(){
		return name;
	}
}
