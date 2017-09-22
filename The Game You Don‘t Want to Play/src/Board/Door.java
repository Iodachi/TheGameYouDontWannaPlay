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
	public void SetColor(String Color){ 
		this.color = Color;
	}

	public String getColor(){
		return this.color;
	}

	public boolean isOpened(){
		return opened;
	}
	
	public void setOpen(boolean opened) {
		this.opened = opened;
	}
}
