package Board;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import character.*;
import gui.View;
import item.*;
import item.Key.KeyType;

public class Level {
	// private List<Entity> entities = new ArrayList<Entity>();
	public static final int BOARDSIZE = 12;
	private Entity entities[][];
	private int floor;
	private int[][] pieces;
	private Shop SType0,SType1,SType2;
	private Temple TType0,TType1,TType2;

	public Level(int floor) {
		this.floor = floor;
		this.entities = new Entity[BOARDSIZE][BOARDSIZE];
		this.pieces = new int[12][12];
		this.SType0 = getShop0();
		this.SType1 = getShop1();
		this.SType2 = getShop2();
		this.TType0 = getTemple0();
		this.TType1 = getTemple1();
		this.TType2 = getTemple2();
		
	}


	//=========================================== Return Method ========================================================	
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
				this.pieces[i][c] = entry;
				AddEntity(entry,i,c,View.TILESIZE,sc);
			}
		}
		sc.next();            //consume )
	}

	/**
	 * Add entities in this level
	 */
	public void AddEntity(int code, int x, int y, int size,Scanner sc) {
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
			//from 50 ~ 60 Stair
		}else if(code >= 50 && code < 60){
			Stairs Stair = new Stairs(code,x,y,size);
			Stair.SetStairs(this.floor);
			this.entities[x][y] = (Entity)Stair;
			//60 ~ 70 shop and temple
		}else if(code >= 60 && code < 70){	
			if(code == 60){
				Ground GroundShop = new Ground(code,x,y,size);
				GroundShop.SetShop(SType0);
				this.entities[x][y] = GroundShop;
			}else if(code == 61){
				Ground GroundShop = new Ground(code,x,y,size);
				GroundShop.SetShop(SType1);
				this.entities[x][y] = GroundShop;
			}else if(code == 62){
				Ground GroundShop = new Ground(code,x,y,size);
				GroundShop.SetShop(SType2);
				this.entities[x][y] = GroundShop;
			}else if(code == 65){
				Ground GroundShop = new Ground(code,x,y,size);
				GroundShop.SetTemple(TType0);
				this.entities[x][y] = GroundShop;
			}else if(code == 66){
				Ground GroundShop = new Ground(code,x,y,size);
				GroundShop.SetTemple(TType1);
				this.entities[x][y] = GroundShop;
			}else if(code == 67){
				Ground GroundShop = new Ground(code,x,y,size);
				GroundShop.SetTemple(TType2);
				this.entities[x][y] = GroundShop;
			}
			//from 90 ~ 99 Monster	
		}else if(code >= 90 && code <= 99){
			Entity GroundMonster = new Ground(code,x,y,size);
			this.entities[x][y] = GroundMonster;
		}

	}

	/**
	 * Shop Type 0 contain 5 GoldKey	
	 * @return
	 */
	public Shop getShop0(){
		Map<Item,Integer> type0 = new HashMap<>();
		type0.put(new Key(-1,-1,KeyType.GoldKey),5);
		return new Shop(type0);
	}

	/**
	 * Shop Type 1 contain 2 bombs, 2 GoldKey and 2 Small BloodVial
	 * @return
	 */
	public Shop getShop1(){
		Map<Item,Integer> type1 = new HashMap<>();
		type1.put(new Bomb(-1,-1), 2);
		type1.put(new Key(-1,-1,KeyType.GoldKey),2);
		type1.put(new BloodVial(-1, -1,"small") , 2);
		return new Shop(type1);
	}
	/**
	 * Shop Type 2 contain 2 GoldKey, 2 CyanKey and 2 BronzeKey
	 * @return
	 */
	public Shop getShop2(){
		Map<Item,Integer> type2 = new HashMap<>();
		type2.put(new Key(-1,-1,KeyType.GoldKey),2);
		type2.put(new Key(-1,-1,KeyType.CyanKey),2);
		type2.put(new Key(-1,-1,KeyType.BronzeKey),2);
		return new Shop(type2);
	}
	
	/**
	 * Temple Type 0 contain ("health", 10)	, ("damage", 10) and ("defence", 10)	
	 * @return
	 */
	public Temple getTemple0(){
		Map<String,Integer> type0 = new HashMap<>();
		type0.put("health", 10);
		type0.put("damage", 10);
		type0.put("defence", 10);
		return new Temple(type0);
	}

	/**
	 * Temple Type 1 contain ("health", 100)	, ("damage", 100) and ("defence", 100)	
	 * @return
	 */
	public Temple getTemple1(){
		Map<String,Integer> type1 = new HashMap<>();
		type1.put("health", 100);
		type1.put("damage", 100);
		type1.put("defence", 100);
		return new Temple(type1);
	}
	
	/**
	 * Temple Type 2 contain ("health", 1000)	, ("damage", 1000) and ("defence", 1000)	
	 * @return
	 */
	public Temple getTemple2(){
		Map<String,Integer> type2 = new HashMap<>();
		type2.put("health", 1000);
		type2.put("damage", 1000);
		type2.put("defence", 1000);
		return new Temple(type2);
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
