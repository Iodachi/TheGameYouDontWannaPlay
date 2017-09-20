package character;

import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

import Board.Board;
import item.Armor;
import item.BloodVial;
import item.Bomb;
import item.ConsumableItem;
import item.FateCoin;
import item.Key;
import item.Weapon;
import item.WearableItem;
import item.Wing;
import item.Key.KeyType;

public class NPC {
	private String name;
	private String talkContent;
	private WearableItem[] equipmentList = { new Armor(0, 0), new Wing(0, 0), new Weapon(0, 0) };
	private ConsumableItem[] consumableItemList = { new BloodVial(0, 0, "small"), new BloodVial(0, 0, "big"),
			new FateCoin(0, 0) };
	private ConsumableItem[] keyAndBomb = { new Key(0, 0, KeyType.BronzeKey), new Key(0, 0, KeyType.CyanKey),
			new Key(0, 0, KeyType.GoldKey), new Key(0, 0, KeyType.PurplyeKey), new Key(0, 0, KeyType.SilverKey) };

	public String getTalkContent() {
		return talkContent;
	}

	public NPC(String name) {
		this.name = name;
	}

	public void talk() {
		switch (name) {
		case "N1":
			talkContent = "111111";
			break;
		case "N2":
			talkContent = "2222222";
			break;
		case "N3":
			talkContent = "333333";
			break;
		case "N4":
			talkContent = "44444";
			break;
		case "N5":
			talkContent = "55555";
			break;

		}
	}

//	public void sellHelper(int NPCID) {
//
//	}

	public void sellEquipment(int option, Player player) {
		int itemCost = 0;
		switch (option) {
		case 1:
			itemCost = equipmentList[0].getCost();
			if (player.getGold() <= itemCost) {
				player.setGold(player.getGold() - itemCost);
				player.pickUp(equipmentList[0]);
			} else {
				System.out.println("sorry, you are too pool.");
			}
			break;
		case 2:
			itemCost = equipmentList[1].getCost();
			if (player.getGold() <= itemCost) {
				player.setGold(player.getGold() - itemCost);
				player.pickUp(equipmentList[1]);
			} else {
				System.out.println("sorry, you are too pool.");
			}
			break;
		case 3:
			itemCost = equipmentList[2].getCost();
			if (player.getGold() <= itemCost) {
				player.setGold(player.getGold() - itemCost);
				player.pickUp(equipmentList[2]);
			} else {
				System.out.println("sorry, you are too pool.");
			}
			break;

		}
	}
}
