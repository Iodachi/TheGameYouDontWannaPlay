package Board;

import java.awt.Rectangle;

public abstract class Entity {
	protected int Code;
	protected int PosX,PosY,size;
	private Rectangle EntityRange;

	public Entity(int code,int x,int y,int size){
		this.Code = code;
		this.PosX = x;
		this.PosY = y;
		this.size = size;
		this.EntityRange = new Rectangle(x * size ,y * size,size,size);
	}

	//================================= Return =========================================================
	/**
	 * 
	 * @return name of the entity
	 */
	public int GetCode() {return this.Code;}
	/**
	 * position X
	 * @return
	 */
	public int GetPosX(){return this.PosX;}

	/**
	 * position Y
	 * @return
	 */
	public int GetPosY(){return this.PosY;}

	/**
	 * Entity Size
	 * @return
	 */
	public int GetSize(){return this.size;}

	/**
	 * Range of the entity
	 * @return
	 */
	public Rectangle GetRange(){return this.EntityRange;}
	//================================= Test ============================================================
	@Override
	public String toString(){ return String.valueOf(this.Code);}

}
