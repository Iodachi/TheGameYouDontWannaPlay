package item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.jar.Attributes.Name;

import character.Monster;

//This class is used to represent that monster manual
public class MonsterManual {
	private String name= "49";
	private HashMap<String,List<Integer>> manual= new HashMap<>();
	public MonsterManual() {
		fillBook();
	}
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
}
