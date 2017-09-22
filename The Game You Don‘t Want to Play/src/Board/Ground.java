package Board;

import character.Monster;
import character.Player;
import item.Item;

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

	/**
	 * Is it lava?
	 * @return
	 */
	public boolean IsLava(){return this.IsLava();}

	/**
	 * Set this ground except Contain Player
	 */
	public void SetGround(){
		if(super.Code == 01) this.IsLava = true;
		else if(super.Code == 03) this.M = null;
	}

	/**
	 * Set Player in this Ground
	 */
	public void SetPlayer(Player p){
		this.P = p;
	}

	/**
	 * if we have move this player then need change Code - 00
	 */
	public void MovePlayer(){
		this.P = null;
		super.Code = 00;
	}

	/**
	 * 00-nothing-GG  01-lava-GL  02-contain player-GP 03-contain monster-GM
	 */
	@Override
	public String toString(){
		if(this.IsLava) return "GL";
		else{
			if(P != null && M == null) return "GP";
			else if(P == null && M != null) return "GM";
		}
		return "GG";
	}

}
