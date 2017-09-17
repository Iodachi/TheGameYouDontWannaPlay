package Board;

import java.util.HashMap;
import java.util.Map;


public class Board {
	private static Map<Integer, Level> levels = new HashMap<Integer, Level>();
	private int CurrentLevel;
	public Board(){
		this.CurrentLevel = 0;
		initialize();
	}

	/**
	 * Return current level
	 */
	public Level GetCurrentLevel(){
		return Board.levels.get(CurrentLevel);
	}

	public void initialize(){
		Level l0 = new Level(0);
		l0.GenerateEntiies(2, 7, 2, 9, "wall");
		l0.GenerateEntiies(3, 8, 3, 9, "wall");
		l0.GenerateEntiies(4, 9, 4, 11, "wall");
		//l0.GenerateEntiies(4, 3, 4, 7, "wall");
		//l0.GenerateEntiies(5, 3, 6, 3, "wall");
		//l0.GenerateEntiies(5, 5, 5, 6, "wall");
		//l0.GenerateEntiies(7, 3, 7, 7, "wall");
		//l0.GenerateEntiies(9, 7, 9, 10, "wall");
		//l0.GenerateEntiies(8, 8, 8, 10, "wall");
		//l0.GenerateEntiies(7, 9, 7, 11, "wall");
		//l0.AddEntity("stair", 5, 4, 60);
		//l0.AddEntity("reddoor", 6, 5,60 );
		//l0.AddEntity("greendoor", 6, 6,60 );
		//l0.AddEntity("irondoor", 5, 8,60 );
		//l0.AddEntity("irondoor", 5, 9,60 );
		l0.FillAllAsGround();
		System.out.println("1");
		Board.levels.put(0, l0);


	}	


}
