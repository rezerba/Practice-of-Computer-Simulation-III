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
	View view;
	private String actions[] = {"attack", "runAway"};
	
	Hero() {
		this.name = "noname";
		this.hp = 100;
		this.maxHP = 100;
		this.gold = 10000;
		this.attackPower = 100;
		this.defencePower = 100;
	}

	Hero(String name, View view) {
		this.name = name;
		this.hp = 100;
		this.maxHP = 100;
		this.gold = 10000;
		this.attackPower = 100;
		this.defencePower = 100;
		this.view = view;
	}
	
	int attack() {
		int atk = ran.nextInt(attackPower / 2 + 1) + attackPower / 2;
		view.showAttack(this.name, atk);
		return atk;
	}

	int defend() {
		int def = ran.nextInt(defencePower / 2 + 1) + defencePower / 2;
		view.showDefend(this.name, def);
		return def;	
	}
	
	int run() {
		return this.runPower * (this.hp / this.maxHP);
	}
	
	int runAway() {
		int run = run();
		view.RunAway(this.name, run);
		return run;
	}
	
	int chase() {
		int chase = run();
		view.Chase(this.name, chase);
		return chase;
	}	
	
	public int selectHeroAction() {
		int action = view.selectHeroAction(this.actions);
		return action;
	}
	
	int gainGold(int gold) {
		view.GainGold(this.name, gold);
		this.gold += gold;
		
		return gold;
	}

	int loseHP(int damage) {
		view.LoseHP(this.name, damage);
		this.hp = (this.hp - damage);
		if (this.hp < 0) {
			return 0;
		} else {
			return this.hp;
		}
	}
	
	int die() {
		view.Die(this.name);
		int tmp = this.gold;
		this.hp = 0;
		this.gold = 0;
		return tmp;
	}

	public String getName() {
		return this.name;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public int getLoseHP(int damage) {
		return damage;
	}
	
	public int getMaxHP() {
		return this.maxHP;
	}
	
	public int getGold() {
		return this.gold;
	}
	
	public int getAttackPower() {
		return this.attackPower;
	}
	
	public int getDefencePower() {
		return this.defencePower;
	}
	
	public int getRunPower() {
		return this.runPower;
	}
	
	//getChase?
	
	public int getAct() {
		return this.act;
	}
}
