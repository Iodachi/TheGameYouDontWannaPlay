package Board;

import character.*;
import item.*;

/**
 * Ground is one of the most important entity which could contain one of 
 * item,shop,temple or monster.
 * @author tian
 *
 * @param <T>
 */
public class Ground<T> extends Entity{
	private T t;
	public Ground(int code, int x, int y, int size) {
		super(code, x, y, size);
		SetGround();
	}

	//===================================== Return ================================================
	/**
	 * Is it lava?
	 * if code name as 01 then it is lava
	 * @return
	 */
	public boolean isLava(){
		return (super.Code == 01);
	}
    
	/**
	 * Return what is this ground contain.
	 * T    - I have a fairy sticks, make me smaller, make me larger and make me prettier.
	 * Shop - you walk by, pass by, but should not miss it! 
	 * @return
	 */
	public T getWhatContain(){return this.t;}

	/**
	 * Pick item then set this become normal ground
	 * @return
	 */
	public boolean pickItem(){
		if(this.t != null && this.t instanceof Item) return SetContainNothing();
		
		return false;
	}	

	/**
	 * When we beat monster then we need clean the battleground set it to normal ground
	 * @return
	 */
	public boolean CleanBattleground(){
		if(this.t != null && this.t instanceof Monster) return SetContainNothing();
		
		return false;
	}	

	/**
	 * Please accept my sincerest and deepest apology, Sorry for we are closed.
	 * @return
	 */
	public boolean CloseShop(){
		if(this.t != null && this.t instanceof Shop) return SetContainNothing();
	
		return false;
	}

	/**
	 *  Myth is Myth, you cannot have good luck every day.
	 * @return
	 */
	public boolean CloseTemple(){
		if(this.t != null && this.t instanceof Temple) return SetContainNothing();
		
		return false;
	}
	
	/**
	 * Your time is over, this time belongs to me!
	 * @return
	 */
	public boolean KillWiseMan(){
		if(this.t != null && this.t instanceof WiseMan) return SetContainNothing();
		
		return false;
	}
	
	/**
	 * Help method for reset this ground to normal ground
	 * @return
	 */
	public boolean SetContainNothing(){
		this.t = null;
		super.Code = 00;
		return true;
	}
	
	// ==================================Initialize====================================================
	/**
	 * Set this ground except Contain Player
	 * 00 - nothing  
	 * 01 - lava
	 * 03 - contain wise man type0      - W0
     * 04 - contain wise man type1      - W1
     * 05 - contain wise man type2      - W2
	 * 20 - GoldDoor - Gold key  - 30
	 * 21 - CyanDoor - Cyan key  - 31
	 * 22 - Bornze D - Bronze K  - 32
	 * 23 - Purplye  - Purplye   - 33
	 * 24 - Silver D - Sliver K  - 34
	 * 40 - Big BloodVial  
	 * 41 - Small BloodVial
	 * 42 - Armor 
	 * 43 - Bomb
	 * 44 - Weapon
	 * 45 - wing
	 * 60 - Shop Type 0
	 * 61 - Shop Type 1
	 * 62 - Shop Type 2
	 * 65 - Temple Type 0 
	 * 66 - Temple Type 1
	 * 67 - Temple Type 2
	 * 91 - M1  92 - M2 93 - M3 94 - M4 95 - M5 96 - M6 97 - M7 98 - M8
	 */ @SuppressWarnings({"unchecked"})
	private  void SetGround() {
		if(super.Code == 03) this.t = (T) new WiseMan(new Armor(-1,-1));
		else if(super.Code == 04) this.t = (T) new WiseMan(new Weapon(-1,-1));
		else if(super.Code == 05) this.t = (T) new WiseMan(new Wing(-1,-1));
		else if(super.Code == 30) this.t = (T) new Key(super.PosX,super.PosY, "gold");
		else if(super.Code == 31) this.t = (T) new Key(super.PosX,super.PosY, "cyan");
		else if(super.Code == 32) this.t = (T) new Key(super.PosX,super.PosY, "bronze");
		else if(super.Code == 33) this.t = (T) new Key(super.PosX,super.PosY, "purple");
		else if(super.Code == 34) this.t = (T) new Key(super.PosX,super.PosY, "silver");
		else if(super.Code == 40) this.t = (T) new BloodVial(super.PosX,super.PosY,"big");
		else if(super.Code == 41) this.t = (T) new BloodVial(super.PosX,super.PosY,"small");
		else if(super.Code == 42) this.t = (T) new Armor(super.PosX,super.PosY);
		else if(super.Code == 43) this.t = (T) new Bomb(super.PosX,super.PosY);
		else if(super.Code == 44) this.t = (T) new Weapon(super.PosX,super.PosY);
		else if(super.Code == 45) this.t = (T) new Wing(super.PosX,super.PosY);
		else if(super.Code == 91) this.t = (T) new Monster(1); // this.M = new Monster(1);
		else if(super.Code == 92) this.t = (T) new Monster(2); // this.M = new Monster(2);
		else if(super.Code == 93) this.t = (T) new Monster(3); // this.M = new Monster(3);
		else if(super.Code == 94) this.t = (T) new Monster(4); // this.M = new Monster(4);
		else if(super.Code == 95) this.t = (T) new Monster(5); // this.M = new Monster(5);
		else if(super.Code == 96) this.t = (T) new Monster(6); // this.M = new Monster(6);
		else if(super.Code == 97) this.t = (T) new Monster(7); // this.M = new Monster(7);
		else if(super.Code == 98) this.t = (T) new Monster(8); // this.M = new Monster(8);     
		
	}

	/**
	 * Cause we want two pieces point to one shop or Temple then we need this method.
	 * @param s
	 * @param code
	 * @return
	 */
	public void SetShopOrTemple(T t){this.t = t;}


	
	//================================= Test ============================================================
	/**
	 * 00 - nothing                     - GG  
	 * 01 - lava                        - GL 
	 * 02 - contain player              - GP 
     * 03 - contain wise man type0      - W0
     * 04 - contain wise man type1      - W1
     * 05 - contain wise man type2      - W2
	 * 20 - GoldDoor - Gold key  - 30   - GK
	 * 21 - CyanDoor - Cyan key  - 31   - CK
	 * 22 - Bornze D - Bronze K  - 32   - BK
	 * 23 - Purplye  - Purplye   - 33   - PK
	 * 24 - Silver D - Sliver K  - 34   - SK
	 * 40 - Big BloodVial               - BB
	 * 41 - Small BloodVial             - SB
	 * 42 - Armor                       - AR
	 * 43 - Bomb                        - BM
	 * 44 - Weapon                      - WP
	 * 45 - wing                        - WG
	 * 60 - Shop Type 0                 - S0
	 * 61 - Shop Type 1                 - S1
	 * 62 - Shop Type 2                 - S2
	 * 65 - Temple Type 0               - T0
	 * 66 - Temple Type 1               - T1
	 * 67 - Temple Type 2               - T2
	 * 91 - M1  92 - M2 93 - M3 94 - M4 95 - M5 96 - M6 97 - M7 98 - M8
	 */
	
	@Override
	public String toString(){
		if( super.Code == 01) return "GL";
		else if(super.Code == 02) return "GP";
		else if(super.Code == 03) return "W0";
		else if(super.Code == 04) return "W1";
		else if(super.Code == 05) return "W5";
		else if(super.Code == 30) return "GK";
		else if(super.Code == 31) return "CK";
		else if(super.Code == 32) return "BK";
		else if(super.Code == 33) return "PK";
		else if(super.Code == 34) return "SK";
		else if(super.Code == 40) return "BB";
		else if(super.Code == 41) return "SB";
		else if(super.Code == 42) return "AR";
		else if(super.Code == 43) return "BM";
		else if(super.Code == 44) return "WP";
		else if(super.Code == 45) return "WG";
		else if(super.Code == 60) return "S0";	
		else if(super.Code == 60) return "S1";	
		else if(super.Code == 62) return "S2";	
		else if(super.Code == 65) return "T0";	
		else if(super.Code == 66) return "T1";
		else if(super.Code == 67) return "T2";	
		else if(super.Code == 91) return "M1";	
		else if(super.Code == 92) return "M2";	
		else if(super.Code == 93) return "M3";	
		else if(super.Code == 94) return "M4";	
		else if(super.Code == 95) return "M5";	
		else if(super.Code == 96) return "M6";	
		else if(super.Code == 97) return "M7";
		else if(super.Code == 98) return "M8";	
		return "GG";
	}


}
