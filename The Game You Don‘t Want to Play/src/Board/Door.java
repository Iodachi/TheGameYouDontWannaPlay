package Board;

public class Door extends Entity{
	public boolean opened = false;
	public String color; 
	
	public Door(String name, int x, int y, int size) {
		super(name, x, y, size);
		// TODO Auto-generated constructor stub
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
	public boolean HasOpen(){return this.opened;}

	/**
	 * Try to open the door
	 */
	public boolean TryOpen(String key){
		if(key.equals(this.color)) {
			this.opened = true;
			return true;
		}
		return false;
	}


}
