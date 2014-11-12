package game.rpg;
import java.util.*;

public class Monster {
	String name;
	int hp, maxHP;
	int gold;
	int attackPower, defencePower;
	int runPower;
	int act;
	
	Random ran = new Random();
	Monster() {
		this.name = "monster";
		this.maxHP = ran.nextInt(81) + 20;
		this.hp = ran.nextInt(this.maxHP + 1) + 20;
		this.gold = ran.nextInt(91) + 10;
		this.attackPower = ran.nextInt(91) + 10;
		this.defencePower = ran.nextInt(91) + 10;
		this.runPower = ran.nextInt(91) + 10;
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
		return  ran.nextInt(3) + 1;
	}

	
	public static void main(String[] args) {
		Monster mon = new Monster();
		System.err.println("name:" + mon.name);
		System.err.println("hp:" + mon.hp);
		System.err.println("attackPower:" + mon.attackPower);
		System.err.println("defencePower:" + mon.defencePower);
		System.err.println("gold:" + mon.gold);
		System.err.println("this.hp:" + mon.hp );
		System.err.println("runPower:" + mon.run());
		System.err.println("act:" + mon.selectAction());
	}
}
