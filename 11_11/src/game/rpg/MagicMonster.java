package game.rpg;

import java.util.Random;

public class MagicMonster extends Monster{
	int mp;
	int maxMP;
	Random ran = new Random();
	
	public MagicMonster(View view) {
		super(view);
		super.name = "MagicMonster";
		this.mp = ran.nextInt(maxMP + 1) + 10;
		this.maxMP = ran.nextInt(81) + 20;
	}
	
	private int atk = super.attack();
	
	int useMagic(int atk) {
		this.mp -= 20;
		if (this.mp < 0) {
			return atk;
		}
		return (int)(atk * 1.5);
	}
	
	int attack() {
		double chance = Math.random();
		if (chance < 0.5) {
			return useMagic(atk);
		}
		System.err.println("Monster attack");
		return atk;
	}
	
	public int getMp() {
		return mp;
	}
	public int getMaxMP() {
		return maxMP;
	}
}
