package Board;

public class Stairs extends Entity{
	private int up,down;
	// true mean up, false mean down
	private boolean UpOrDown = true;

	/**
	 * 51 - up stair 
	 * 52 - down stair
	 * @param code
	 * @param x
	 * @param y
	 * @param size
	 */
	public Stairs(int code, int x, int y, int size) {
		super(code, x, y, size);
		// TODO Auto-generated constructor stub
	}

	/**
	 * set for up stair and down stair
	 * @param up
	 * @param down
	 */
	public void SetStairs(int floor){
		if(super.Code == 51) this.up = floor + 1;
		else if(super.Code == 52) this.down = floor - 1;
	}

	/**
	 * return true mean this stair is up stair 
	 * otherwise return false
	 * @return
	 */
	public boolean UpOrDownStair(){ return this.UpOrDown;}

	/**
	 * if it is up stair then return up
	 * @return
	 */
	public int GetUpStair(){return this.up;}

	/**
	 * if it is down stair then return down
	 * @return
	 */
	public int GetDownStair(){return this.down;}

	@Override
	public String toString(){
		String temp = null;
		if(super.Code == 51) temp = "US";
		else if(super.Code == 52) temp = "DS";
		return temp;
	}

}
