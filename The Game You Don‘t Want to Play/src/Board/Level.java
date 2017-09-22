package Board;

import java.util.Scanner;
import gui.View;

public class Level {
	// private List<Entity> entities = new ArrayList<Entity>();
	public static final int BOARDSIZE = 12;
	private Entity entities[][];
	private int floor;
	private int[][] pieces;

	public Level(int floor) {
		this.floor = floor;
		entities = new Entity[BOARDSIZE][BOARDSIZE];
		this.pieces = new int[12][12];
	}


	//=========================================== Return Method ====================================================	
	/**
	 * if pick the item on the ground then set ground into normal ground
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean PickItem(int x, int y){
		if(this.entities[x][y] instanceof Ground){
			return ((Ground) this.entities[x][y]).PickItem();
		}
		return false;
	}

	/**
	 * if break the wall then set normal ground into this coords of entities
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean BreakWall(int x, int y){
		if(this.entities[x][y] instanceof Wall){
			if( ((Wall) this.entities[x][y]).IsWallBreakable()){
				this.entities[x][y] = new Ground(00,x,y,View.TILESIZE);
				return true;
			}
		}
		return false;
	}

	/**
	 * what is the number of this level
	 * 
	 * @return
	 */
	public int Getfloor() {return this.floor;}


	/**
	 * return Entity at Given Position
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public Entity GetEntityAt(int x, int y) {return entities[x][y];}

	/**
	 * return the array of entities
	 * @return
	 */
	public Entity[][] getEntities() {return entities;}

	//============================================= initialize =======================================================
	/**
	 * Parser a  12*12 board
	 * @param sc
	 */
	public void ParserLevel(Scanner sc){
		sc.next();           //consume (
		for(int i = 0; i < BOARDSIZE; i++ ){
			for(int c = 0; c < BOARDSIZE; c++ ){
				int entry = sc.nextInt();
				//System.out.println(entity);
				this.pieces[i][c] = entry;
				AddEntity(entry,i,c,View.TILESIZE);
			}
		}
		sc.next();
	}

	/**
	 * Add entities in this level
	 */
	public void AddEntity(int code, int x, int y, int size) {
		// from 00 ~09  Ground
		if(code < 10){
			Entity Ground = new Ground(code,x,y,size);
			this.entities[x][y] = Ground;
			//from 10 ~ 19  Wall
		}else if(code >= 10 && code < 20){
			Entity Wall = new Wall(code,x,y,size);
			this.entities[x][y] = Wall;
			//from 20 ~ 30 Door	
		}else if(code >= 20 && code < 30){
			Entity D = new Door(code,x,y,size);
			this.entities[x][y] = D;
			//from 30 ~ 50 Item	
		}else if(code >= 30 && code < 50){
			Entity GroundItem = new Ground(code,x,y,size);
			this.entities[x][y] = GroundItem;
		}else if(code >= 50 && code < 60){
			Stairs Stair = new Stairs(code,x,y,size);
			Stair.SetStairs(this.floor);
			this.entities[x][y] = (Entity)Stair;
			//from 90 ~ 99 Monster	
		}else if(code >= 90 && code <= 99){
			Entity GroundMonster = new Ground(code,x,y,size);
			this.entities[x][y] = GroundMonster;
		}

	}

	//============================================= Test =================================================================
	/**
	 * Use for test
	 */
	public void Print() {
		for (int i = 0; i < 12; i++) {
			StringBuilder temp = new StringBuilder();
			for (int c = 0; c < 12; c++) {
				if(this.pieces[i][c] == 0) temp.append(" 00");
				else if(this.pieces[i][c] == 1) temp.append(" 01");
				else if(this.pieces[i][c] == 2) temp.append(" 02");
				else temp.append(" " + this.pieces[i][c]);
			}
			System.out.println(temp);
		}
	}

	public void Print1(){
		for (int i = 0; i < 12; i++) {
			StringBuilder temp = new StringBuilder();
			for (int c = 0; c < 12; c++) {
				temp.append(" " + GetEntityAt(i,c).toString());
			}
			System.out.println(temp);
		}
	}


}
