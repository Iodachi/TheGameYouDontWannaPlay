package Board;


public class Door extends Entity{
	public boolean opened = false;
	public String color; 
	private String name;
	//DB DC DG DP DS
	public String getName() {
		return name;
	}
	
	public Door(String name, int x, int y, int size) {
		super(name, x, y, size);
		this.name = name;
		
	}
	
	/**
	 * Suppose we have different color doors, this method will help for initialize
	 * @param Color
	 */
	public void SetColor(String Color){ this.color = Color;}

	/**
	 * Color use for draw and check openable
	 * @return
	 */
	public String GetColor(){return this.color;}

	/**
	 * if this door has opened then if should disappear
	 * @return
	 */
	public boolean isOpened(){
		return opened;
	}

	public void open() {
		opened = true;
		//TODO: what happens when door is opened
	}

}
