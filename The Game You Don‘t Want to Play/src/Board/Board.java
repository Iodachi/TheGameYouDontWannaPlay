package Board;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Board {
	private static final int TOWERHIGHT =10;
	private static Map<Integer, Level> levels = new HashMap<Integer, Level>();
	private int currentLevel;
	public Board(){
		this.currentLevel = 1;
		initialize();
	}
	//====================================== Return ======================================================

	/**
	 * Return current level
	 */
	public Level GetCurrentLevel(){
		return Board.levels.get(currentLevel);
	}
	
	public int getCurrentLevelNumber() {
		return currentLevel;
	}
	
	public void setCurrentLevel(int level) {
		currentLevel = level;
	}

	public Collection<Level> GetAllLevel(){
		return this.levels.values();
	}
	//================================== initialize ======================================================
	public void initialize(){
		String fileName = "load"+".txt";
		try {
			InputStream is = Board.class.getResourceAsStream(fileName);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

			Scanner sc = new Scanner(bufferedReader);
			while(sc.hasNext()){
				if(sc.hasNext("l")){
					sc.next();      //consume l
					int NumOfLevel = sc.nextInt();
					Level temp = new Level(NumOfLevel);
					temp.ParserLevel(sc);
					this.levels.put(NumOfLevel, temp);
				}
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
	}	

}
