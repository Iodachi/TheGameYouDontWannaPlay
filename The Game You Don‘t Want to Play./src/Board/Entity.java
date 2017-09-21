package Board;

import java.awt.Rectangle;

public abstract class Entity  {
	private String name;
	private int PosX,PosY,size;
	private Rectangle EntityRange;


	public Entity(String name,int x,int y,int size){
		this.name = name;
		this.PosX = x;
		this.PosY = y;
		this.size = size;
		this.EntityRange = new Rectangle(x * size ,y * size,size,size);
	}
	/**
	 * 
	 * @return name of the entity
	 */
	public String getName() {return this.name;}
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

	@Override
	public String toString(){ return this.name.substring(0, 1);}

}
