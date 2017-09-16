package item;

import character.Player;

/**
 * Created by minpingyang on 16/09/17.
 */
public class Bomb extends ConsumableItem {
    private int x,y;

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
}
