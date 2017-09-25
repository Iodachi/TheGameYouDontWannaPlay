package Board;
/**
 * Door instance as different color door that could open by specific key 
 * @author tian
 *
 */
public class Door extends Entity{
	public String color;

	public Door(int code, int x, int y, int size) {
		super(code, x, y, size);
		if(code == 20)	color = "gold";
		if(code == 21)	color = "cyan";
		if(code == 22)	color = "bronze";
		if(code == 23)	color = "purple";
		if(code == 24)	color = "silver";
	}
	//================================= Return =========================================================

	public String getColor(){
		return this.color;
	}

	//================================= Test ============================================================
	@Override
	public String toString(){
		if(super.Code == 20){
			color = "DG";
		}else if(super.Code == 21){
			color = "DC";
		}else if(super.Code == 22){
			color = "DB";
		}else if(super.Code == 23){
			color = "DP";
		}else if(super.Code == 24){
			color = "DS";
		}
		return color;
	}

}
