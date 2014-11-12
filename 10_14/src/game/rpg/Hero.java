package game.rpg;

import java.util.*;

public class Hero {
	String name;
	int hp, maxHP;
	int gold;
	int attackPower, defencePower;
	int runPower;
	int act;
	Random ran = new Random();

	Hero() {
		this.name = "noname";
		this.hp = 100;
		this.maxHP = 100;
		this.gold = 10_000;
		this.attackPower = 100;
		this.defencePower = 100;
		this.runPower = 100;
	}

	Hero(String name) {
		this.name = name;
		this.hp = 100;
		this.maxHP = 100;
		this.gold = 10_000;
		this.attackPower = 100;
		this.defencePower = 100;
		this.runPower = 100;
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
	
	int gainGold(int gold) {
		this.gold += gold;
		return this.gold;
	}

	int loseHP(int damage) {
		this.hp -= damage;
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
	
	int selectAction() {
		System.out.println("select action (1)attack (2)run");
		this.act = new Scanner(System.in).nextInt();
		return this.act;
	}
	
	public static void main(String[] args) {
		Hero hero = new Hero();
		System.err.println("name:" + hero.name);
		System.err.println("hp:" + hero.hp);
		System.err.println("attackPower:" + hero.attack());
		System.err.println("defencePower:" + hero.defend());
		System.err.println("gold:" + hero.gold);
		System.err.println("runPower:" + hero.run());
		hero.selectAction();
		System.err.println();
		
		String name = "hoge";
		Hero hero2 = new Hero(name);
		System.err.println("name:" + hero2.name);
		System.err.println("hp:" + hero2.hp);
		System.err.println("attackPower:" + hero2.attack());
		System.err.println("defencePower:" + hero2.defend());
		System.err.println("gold:" + hero2.gold);
	}
}
