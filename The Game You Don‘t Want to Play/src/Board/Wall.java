package Board;

public class Wall extends Entity{

	private boolean breakable = false;
	public Wall(int code, int x, int y, int size) {
		super(code, x, y, size);
		// TODO Auto-generated constructor stub
		SetBreakable();
	}

	/**
	 * Is this wall breakable?
	 * @return
	 */
	public boolean IsWallBreakable(){return this.breakable;}

	/**
	 * set this wall to be break able;
	 */
	public void SetBreakable(){
		if(super.Code == 11) this.breakable = true;
	}

	/**
	 *  10 - normal wall - WW,   11 - Breakable wall - WB
	 */
	@Override
	public String toString(){
		if(this.breakable) return  "WB";
		return "WW";
	}

}
