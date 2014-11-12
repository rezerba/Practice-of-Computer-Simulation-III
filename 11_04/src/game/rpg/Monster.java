package game.rpg;
import java.util.*;

public class Monster {
	protected String name;
	private int hp, maxHP;
	private int gold;
	private int attackPower, defencePower;
	private int runPower;
	private int act;
	private Random ran = new Random();
	View view = new View();
	
	Monster() {
		this.name = "Monster";
		this.maxHP = ran.nextInt(81) + 20;
		this.hp = ran.nextInt(this.maxHP + 1) + 20;
		this.gold = ran.nextInt(91) + 10;
		this.attackPower = ran.nextInt(91) + 10;
		this.defencePower = ran.nextInt(91) + 10;
		this.runPower = ran.nextInt(91) + 10;
		this.act = ran.nextInt(3) + 1;
	}
	
	Monster(View view) {
		view.showAttack(this.name, this.attack());
		view.showDefend(this.name, this.defend());
		view.RunAway(this.name, this.run());
		view.Chase(this.name, this.run());
		view.GainGold(this.name, this.gainGold(gold));
		view.GainHP(this.name, this.hp);
		//view.LoseHP(this.name, damage);
		view.Die(this.name);
	}
	
	int attack() {
		int atk = ran.nextInt(attackPower / 2 + 1) + attackPower / 2;
		view.showAttack(this.name, atk);
		return atk;
	}

	int defend() {
		int def = ran.nextInt(defencePower / 2 + 1) + defencePower / 2;
		view.showDefend(this.name, def);
		return 	def;
	}
	
	int run() {
		int run = this.runPower * (this.hp / this.maxHP);
		view.RunAway(this.name, run);
		return run;
	}
	
	int chase() {
		int chase = run();
		view.Chase(this.name, chase);
		return chase;
	}
	
	int selectAction() {
		return  this.act;
	}
	
	
	int gainGold(int gold) {
		view.GainGold(this.name, gold);
		this.gold += gold;
		return this.gold;
	}

	int loseHP(int damage) {
		view.LoseHP(this.name, damage);
		this.hp = (this.hp - damage);
		if ((this.hp) < 0) {
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
		return name;
	}
	
	public int getHp() {
		return this.hp;
	}
	
	public int getMaxHP() {
		return maxHP;
	}
	
	public int getLoseHP(int damage) {
		return damage;
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
	
	public int getRunPower() {
		return runPower;
	}
}
