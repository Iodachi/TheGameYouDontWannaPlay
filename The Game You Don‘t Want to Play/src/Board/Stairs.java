package Board;
/**
 * Stair is use for player move into other level
 * @author tian
 *
 */
public class Stairs extends Entity{
	private int up,down;
	// true point to up stair, false point to down stair
 	private boolean UpOrDown = true;

	public Stairs(int code, int x, int y, int size) {
		super(code, x, y, size);
		// TODO Auto-generated constructor stub
	}
	//================================= Initialize =========================================================
	/**
	 * set for up stair and down stair
	 * @param up
	 * @param down
	 */
	public void SetStairs(int floor){
		if(super.Code == 51) this.up = floor + 1;
		else if(super.Code == 52) this.down = floor - 1;
	}
	//================================= Return =========================================================
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
	//================================= Test ===========================================================
	@Override
	public String toString(){
		String temp = null;
		if(super.Code == 51) temp = "US";
		else if(super.Code == 52) temp = "DS";
		return temp;
	}

}
