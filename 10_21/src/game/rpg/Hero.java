package game.rpg;

import java.util.*;

public class Hero {
	private String name;
	private int hp, maxHP;
	private int gold;
	private int attackPower, defencePower;
	private int runPower;
	private int act;
	Random ran = new Random();
	
	Hero() {
		this.name = "noname";
		this.hp = 100;
		this.maxHP = 100;
		this.gold = 10000;
		this.attackPower = 100;
		this.defencePower = 100;
	}

	Hero(String name) {
		this.name = name;
		this.hp = 100;
		this.maxHP = 100;
		this.gold = 10000;
		this.attackPower = 100;
		this.defencePower = 100;
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
		this.act = new Scanner(System.in).nextInt();
		return this.act;
	}
	
	int gainGold(int gold) {
		this.gold += gold;
		return gold;
	}

	int loseHP(int damage) {
		this.hp = (this.hp - damage);
		if (this.hp < 0) {
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
		Hero hero = new Hero();
		System.err.println("name:" + hero.name);
		System.err.println("hp:" + hero.hp);
		System.err.println("attackPower:" + hero.attack());
		System.err.println("defencePower:" + hero.defend());
		System.err.println("gold:" + hero.gold);
		System.err.println();
		
		String name = "hoge";
		Hero hero2 = new Hero(name);
		System.err.println("name:" + hero2.name);
		System.err.println("hp:" + hero2.hp);
		System.err.println("attackPower:" + hero2.attack());
		System.err.println("defencePower:" + hero2.defend());
		System.err.println("gold:" + hero2.gold);
	}

	public int getGold() {
		return this.gold;
	}
	public int getHp() {
		return this.hp;
	}
	public String getName() {
		return name;
	}
	public int getMaxHP() {
		return maxHP;
	}
	public int getAttackPower() {
		return attackPower;
	}
	public int getDefencePower() {
		return defencePower;
	}
	public int getRunPower() {
		return runPower;
	}
	public int getAct() {
		return act;
	}
}
