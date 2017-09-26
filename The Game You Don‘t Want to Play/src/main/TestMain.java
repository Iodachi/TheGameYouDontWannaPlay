package main;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.junit.Test;

import Board.Board;

public class TestMain {

	@Test
	public void test01() throws InvalidMove {
		String token = 
				"l 1 (\n" 
						+	" 00 00 00 00 00 00 00 00 00 00 00 00\n"
						+	" 00 01 01 01 01 00 01 01 01 01 01 00\n"
						+	" 00 01 01 01 01 30 01 01 00 00 00 00\n"
						+	" 00 01 01 01 01 30 01 01 00 01 01 01\n"
						+	" 00 01 01 01 00 30 00 01 00 00 00 00\n"
						+	" 00 01 01 01 00 01 00 01 01 01 01 00\n"
						+	" 00 01 01 01 00 01 00 01 00 00 00 00\n"
						+	" 00 01 01 01 00 00 00 01 00 01 01 01\n"
						+	" 00 01 01 01 01 93 01 01 00 00 00 00\n"
						+	" 00 01 01 01 01 30 01 01 01 01 01 00\n"
						+	" 00 01 01 01 01 43 01 00 00 00 00 00\n"
						+	" 00 00 00 00 00 51 01 00 01 01 01 01\n"
						+	")\n";
		Game g = new Game();
		g.move("down");
		assertEquals(token,g.board.GetCurrentLevel().toString());
	}


	@Test
	public void test02(){
		Game g = new Game();
		g.save();
		try {
			InputStream loadfile = Board.class.getResourceAsStream("OriginalMap.txt");
			FileReader savefile =  new FileReader("save.txt");
			BufferedReader load = new BufferedReader(new InputStreamReader(loadfile));
			BufferedReader save = new BufferedReader(savefile);
			save.readLine();
			save.readLine();
			save.readLine();
			save.readLine();
			
			Scanner sc1 = new Scanner(load);
			Scanner sc2 = new Scanner(save);
			StringBuilder str1 = new StringBuilder();
			StringBuilder str2 = new StringBuilder();
			while(sc1.hasNext()) str1.append(sc1.next());
			while(sc2.hasNext()) str2.append(sc2.next());
			assertEquals(str1.toString(),str2.toString());
			if(!str1.toString().equals(str2.toString())){
				System.out.println(str1);
				System.out.println(str2);
			}

		} catch (FileNotFoundException ex) {
			System.out.println(ex);
		} catch (IOException ex) {
			System.out.println(ex);
		}
	}
	
	@Test
	public void test03(){
		new Game("save.txt");
	}
}
