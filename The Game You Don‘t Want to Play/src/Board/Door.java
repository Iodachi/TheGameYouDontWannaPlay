package Board;


public class Door extends Entity{
	public boolean opened = false;

	/**
	 * specify Door by different code  
	 * 20 - GoldDoor - Gold key  - 30
	 * 21 - CyanDoor - Cyan key  - 31
	 * 22 - Bornze D - Bronze K  - 32
	 * 23 - Purplye  - Purplye   - 33
	 * 24 - Silver D - Sliver K  - 34
	 * @param code
	 * @param x
	 * @param y
	 * @param size
	 */
	public Door(int code, int x, int y, int size) {
		super(code, x, y, size);

	}

	/**
	 * if this door has opened then if should disappear
	 * @return
	 */
	public boolean HasOpen(){return this.opened;}

	/**
	 * return the code of this door
	 * @return
	 */
	public int GetDoorCode(){return super.Code;}

	

	@Override
	public String toString(){
		String Color = null;
		if(super.Code == 20){
			Color = "DG";
		}else if(super.Code == 21){
			Color = "DC";
		}else if(super.Code == 22){
			Color = "DB";
		}else if(super.Code == 23){
			Color = "DP";
		}else if(super.Code == 24){
			Color = "DS";
		}
		return Color;
	}

}
