package game.rpg;

import java.util.Random;

public  abstract class GameChara {
	protected String name;
	protected int hp, maxHP;
	protected int gold;
	protected int attackPower, defencePower;
	protected int runPower;
	Random ran = new Random();
	View view;
	
	public GameChara(View view) {
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
	
	// abstract
	abstract int selectAction();

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
}
