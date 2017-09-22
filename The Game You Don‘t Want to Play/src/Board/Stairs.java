package Board;

public class Stairs extends Entity{
	private int up,down;
	public Stairs(int code, int x, int y, int size) {
		super(code, x, y, size);
		// TODO Auto-generated constructor stub
	}

	/**
	 * set for up stair and down stair
	 * @param up
	 * @param down
	 */
	public void SetStairs(int up, int down ){
		this.up = up;
		this.down = down;
	}
	
	/**
	 * Return which level is up stair
	 * @return
	 */
	public int GetUpStair(){return this.up;}
	/**
	 * Return which level is down stair
	 * @return
	 */
	public int GetDownStair(){return this.down;}

}
