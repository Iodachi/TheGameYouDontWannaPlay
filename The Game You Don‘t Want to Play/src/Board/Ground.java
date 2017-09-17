package Board;

public class Ground extends Entity{

	private Boolean IsLava = false;
	public Ground(String name, int x, int y, int size) {
		super(name, x, y, size);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Is it lava?
	 * @return
	 */
	public boolean IsLava(){return this.IsLava();}
	
	/**
	 * Set it is lava
	 */
	public void SetIsLava(){this.IsLava = true;}

}
