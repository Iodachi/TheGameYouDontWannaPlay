package Board;

import java.util.Scanner;

import character.Player;
import gui.View;

public class Level {
	// private List<Entity> entities = new ArrayList<Entity>();
	public static final int BOARDSIZE = 12;
	private Entity entities[][];
	private int floor;
	private int[][] pieces;
	private Player player;

	public Level(int floor) {
		this.floor = floor;
		entities = new Entity[BOARDSIZE][BOARDSIZE];
		this.pieces = new int[12][12];

		//initialize();
	}

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
			Entity G = new Ground(code,x,y,size);
			this.entities[x][y] = G;
			//from 10 ~ 19
		}else if(code >=10 && code < 20){
			Entity G = new Wall(code,x,y,size);
			this.entities[x][y] = G;
		}
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

	/**
	 * Use for test
	 */
	public void Print() {
		for (int i = 0; i < 12; i++) {
			StringBuilder temp = new StringBuilder();
			for (int c = 0; c < 12; c++) {
				if(this.pieces[i][c] == 0) temp.append(" 00");
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
