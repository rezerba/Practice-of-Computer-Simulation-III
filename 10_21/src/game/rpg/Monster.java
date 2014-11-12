package game.rpg;
import java.util.*;

public class Monster {
	private String name;
	private int hp, maxHP;
	private int gold;
	private int attackPower, defencePower;
	private int runPower;
	private int act;
	private Random ran = new Random();
	
	Monster() {
		this.name = "monster";
		this.maxHP = ran.nextInt(81) + 20;
		this.hp = ran.nextInt(this.maxHP + 1) + 20;
		this.gold = ran.nextInt(91) + 10;
		this.attackPower = ran.nextInt(91) + 10;
		this.defencePower = ran.nextInt(91) + 10;
		this.runPower = ran.nextInt(91) + 10;
		this.act = ran.nextInt(3) + 1;
	}
	
	int attack() {
		return ran.nextInt(attackPower / 2 + 1) + attackPower / 2;
	}

	int defend() {
		return ran.nextInt(defencePower / 2 + 1) + defencePower / 2;	
	}
	
	int run() {
		return this.runPower * (this.hp / this.maxHP);
	}
	
	public int chase() {
		return run();
	}
	
	public int runAway() {
		return run();
	}
	
	int selectAction() {
		return  this.act;
	}
	
	int gainGold(int gold) {
		this.gold = (this.gold + gold);
		return this.gold;
	}

	int loseHP(int damage) {
		this.hp = (this.hp - damage);
		if ((this.hp) < 0) {
			return 0;
		} else {
			return this.hp;
		}
	}
	
	int die() {
		int tmp = this.gold;
		this.hp = 0;
		this.gold = 0;
		return tmp;
	}
	
	public static void main(String[] args) {
		Monster mon = new Monster();
		System.err.println("name:" + mon.name);
		System.err.println("hp:" + mon.hp);
		System.err.println("attackPower:" + mon.attackPower);
		System.err.println("defencePower:" + mon.defencePower);
		System.err.println("gold:" + mon.gold);
		System.err.println("this.hp:" + mon.hp);
	}

	public String getName() {
		return name;
	}
	public int getHp() {
		return this.hp;
	}
	public int getMaxHP() {
		return maxHP;
	}
	public int getGold() {
		return this.gold;
	}
	public int getAttackPower() {
		return attackPower;
	}
	public int getDefencePower() {
		return defencePower;
	}
	public int getAct() {
		return act;
	}
}
