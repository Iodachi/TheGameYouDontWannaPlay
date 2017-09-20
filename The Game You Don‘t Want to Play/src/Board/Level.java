package Board;


import character.Player;

public class Level {
	// private List<Entity> entities = new ArrayList<Entity>();
	public static final int BOARDSIZE = 12;
	private Entity entities[][];
	private int floor;
	private int[][] pieces;
	private Player player;

	public Level(int floor) {
		this.floor = floor;
		//this.pieces = new int[12][12];
		entities = new Entity[BOARDSIZE][BOARDSIZE];
		GenerateEntiies(0, 0, 0, 11, "wall");
		GenerateEntiies(0, 0, 11, 0, "wall");
		GenerateEntiies(11, 0, 11, 11, "wall");
		GenerateEntiies(0, 11, 11, 11, "wall");
	}

	/**
	 * For a given coords check is there moveable
	 * 
	 * @return
	 */
	public Boolean MoveAble(int x, int y) {
		Entity temp = GetEntityAt(x, y);
		if (temp instanceof Ground && !((Ground) temp).IsLava())
			return true;
		return false;
	}

	/**
	 * what is the number of this level
	 * 
	 * @return
	 */
	public int Getfloor() {
		return this.floor;
	}

	/**
	 * Add entities in this level
	 */
	public void AddEntity(String Entity, int x, int y, int size) {
		if (Entity.equals("wall"))
			this.entities[x][y] = new Wall(Entity, x, y, size);
		else if (Entity.equals("ground"))
			this.entities[x][y] = (new Ground(Entity, x, y, size));
		else if (Entity.equals("lava")) {
			Ground lava = new Ground("ground", x, y, size);
			lava.SetIsLava();
			this.entities[x][y] = lava;
		} else if (Entity.equals("reddoor"))
			this.entities[x][y] = (new Door(Entity, x, y, size));
		else if (Entity.equals("greendoor"))
			this.entities[x][y] = (new Door(Entity, x, y, size));
		else if (Entity.equals("irondoor"))
			this.entities[x][y] = (new Door(Entity, x, y, size));
		else if (Entity.equals("stair"))
			this.entities[x][y] = (new Stairs(Entity, x, y, size));
		
	}

	/**
	 * make long Entities2
	 */
	public void GenerateEntiies(int fromX, int fromY, int ToX, int ToY, String Entity) {
		// horizontal case
		if (fromX == ToX) {
			// from left to right
			if (fromY < ToY) {
				for (int i = 0; i <= ToY - fromY; i++)
					AddEntity(Entity, fromX, fromY + i, 60);
				// from right to left
			} else {
				for (int i = 0; i <= fromY - ToY; i++)
					AddEntity(Entity, fromX, fromY + i, 60);

			}
			// vertical case
		} else if (fromY == ToY) {
			// from up to down
			if (fromX < ToX) {
				for (int i = 0; i <= ToX - fromX; i++)
					AddEntity(Entity, fromX + i, fromY, 60);
				// from down to up
			} else {
				for (int i = 0; i <= fromX - ToX; i++)
					AddEntity(Entity, fromX + i, fromY, 60);
			}
		}
	}

	/**
	 * return Entity at Given Position
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Entity GetEntityAt(int x, int y) {
		
		return entities[x][y];
	}

	// /**
	// * if it has Opened Door then replace door to ground
	// */
	// public void OpenDoor(int x, int y,String key){
	// Entity tempdoor = GetEntityAt(x,y);
	// if(tempdoor instanceof Door){
	// if(((Door) tempdoor).TryOpen(key)){
	// ((Door) tempdoor).HasOpen();
	// int PosX = tempdoor.GetPosX();
	// int PosY = tempdoor.GetPosY();
	// int Size = tempdoor.GetSize();
	// this.entities.remove(tempdoor);
	// AddEntity("ground",PosX,PosY,Size);
	// }
	// }
	//
	// }

	/**
	 * set all entities in this 12*12 map, fill empty as ground
	 */
	public void FillAllAsGround() {
		for (int i = 0; i < 12; i++) {
			for (int c = 0; c < 12; c++) {
				if (GetEntityAt(i, c) == null)
					AddEntity("ground", i, c, 60);
			}
		}
	}

	public void Print() {

		for (int i = 0; i < 12; i++) {
			StringBuilder temp = new StringBuilder();
			for (int c = 0; c < 12; c++) {
				temp.append(GetEntityAt(i, c).toString());
			}
			System.out.println(temp);
		}
	}

	public Entity[][] getEntities() {
		return entities;
	}

}
