package Board;

import character.Monster;
import character.Player;
import item.*;
import item.Key.KeyType;


public class Ground extends Entity{
	private Boolean IsLava = false;
	private Player P;
	private Monster M;
	private Item I;
	public Ground(int code, int x, int y, int size) {
		super(code, x, y, size);
		// TODO Auto-generated constructor stub
		SetGround();
	}

	//===================================== Return =============================================
	/**
	 * Is it lava?
	 * @return
	 */
	public boolean IsThisLava(){
		if(super.Code == 01) return true;
		return false;
	}


	/**
	 * Set Player in this Ground
	 */
	public boolean SetPlayer(Player p){
		if(this.P == null){
			this.P = p;
			super.Code = 01;
			return true;
		}
		return false;
	}
	/**
	 * if we have move this player then need change Code - 00
	 */
	public void MovePlayer(){
		this.P = null;
		super.Code = 00;
	}

	/**
	 * Pick item then set this become normal ground
	 * @return
	 */
	public boolean PickItem(){
		if(this.I != null){
			this.I = null;
			super.Code = 00;
			return true;
		}
		return false;
	}	
	// ==================================Initialize====================================================
	/**
	 * Set this ground except Contain Player
	 * 00 - nothing  
	 * 01 - lava
	 * 02 - contain player-GP 
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
	 * 91 - M1  92 - M2 93 - M3 94 - M4 95 - M5 96 - M6 97 - M7 98 - M8
	 */
	private void SetGround(){
		if(super.Code == 01) this.IsLava = true;
		else if(super.Code == 02) this.P = new Player().setPos(super.PosX, super.PosY);
		else if(super.Code == 30) this.I = new Key(super.PosX,super.PosY,KeyType.GoldKey);
		else if(super.Code == 31) this.I = new Key(super.PosX,super.PosY,KeyType.CyanKey);
		else if(super.Code == 32) this.I = new Key(super.PosX,super.PosY,KeyType.BronzeKey);
		else if(super.Code == 33) this.I = new Key(super.PosX,super.PosY,KeyType.PurplyeKey);
		else if(super.Code == 34) this.I = new Key(super.PosX,super.PosY,KeyType.SilverKey);
		else if(super.Code == 40) this.I = new BloodVial(super.PosX,super.PosY,"big");
		else if(super.Code == 41) this.I = new BloodVial(super.PosX,super.PosY,"small");
		else if(super.Code == 42) this.I = new Armor(super.PosX,super.PosY);
		else if(super.Code == 43) this.I = new Bomb(super.PosX,super.PosY);
		else if(super.Code == 44) this.I = new Weapon(super.PosX,super.PosY);
		else if(super.Code == 45) this.I = new Wing(super.PosX,super.PosY);
		else if(super.Code == 91) this.M = new Monster(1);
		else if(super.Code == 92) this.M = new Monster(2);
		else if(super.Code == 93) this.M = new Monster(3);
		else if(super.Code == 94) this.M = new Monster(4);
		else if(super.Code == 95) this.M = new Monster(5);
		else if(super.Code == 96) this.M = new Monster(6);
		else if(super.Code == 97) this.M = new Monster(7);
		else if(super.Code == 98) this.M = new Monster(8);
	}


	/**
	 * 00 - nothing                     - GG  
	 * 01 - lava                        - GL 
	 * 02 - contain player              - GP 
	 * 03 - contain monster             - GM
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
	 * 91 - M1  92 - M2 93 - M3 94 - M4 95 - M5 96 - M6 97 - M7 98 - M8
	 */
	@Override
	public String toString(){
		if( super.Code == 01) return "GL";
		else if(super.Code == 02) return "GP";
		else if(super.Code == 03) return "GM";
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
