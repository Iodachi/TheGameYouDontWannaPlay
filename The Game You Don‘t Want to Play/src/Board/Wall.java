package Board;

public class Wall extends Entity{

	public Wall(int code, int x, int y, int size) {
		super(code, x, y, size);
		// TODO Auto-generated constructor stub
	}


	//================================= Return =========================================================
	/**
	 * Is this wall breakable?
	 * If code name equal to 11 then it means breakable
	 * @return
	 */

	public boolean IsWallBreakable(){
		if(super.Code == 11) return true;
		return false;
	}

	//================================= Test ============================================================
	/**
	 * 10 - normal wall    - WW   
	 * 11 - Breakable wall - WB
	 */
	@Override
	public String toString(){
		if(super.Code == 11) return  "WB";
		return "WW";
	}

}
