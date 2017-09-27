package item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.jar.Attributes.Name;

import character.Monster;
import character.Player;

//This class is used to represent that monster manual
public class MonsterManual extends ConsumableItem{
	private String name="49";
	private int x;
	private int y;
	private HashMap<String,List<Integer>> manual= new HashMap<>();
	public MonsterManual() {
		fillBook();
	}
	
	//This method is used to store all information of monster into the hashMap
	public void fillBook() {
		for(int i=1;i<9;i++) {
			Monster monster = new Monster(i);
			List<Integer> attributes = new ArrayList<>();
			attributes.add(monster.getHealth());
			attributes.add(monster.getDamage());
			attributes.add(monster.getDefence());
			manual.put(monster.getName(),attributes);
		}

	}
	public HashMap<String, List<Integer>> getManual(){return manual;}
	@Override
	public boolean on(int x, int y) {
		return this.x ==x&&this.y==y;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void use(Player player) {
		
	}
}
