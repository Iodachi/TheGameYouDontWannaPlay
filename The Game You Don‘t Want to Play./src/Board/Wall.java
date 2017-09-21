package Board;

public class Wall extends Entity{

	private boolean breakable = false;
	public Wall(String name, int x, int y, int size) {
		super(name, x, y, size);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Is this wall breakable?
	 * @return
	 */
	public boolean IsWallBreakable(){return this.breakable;}

	/**
	 * set this wall to be break able;
	 */
	public void SetBreakable(){this.breakable = true;}
}
