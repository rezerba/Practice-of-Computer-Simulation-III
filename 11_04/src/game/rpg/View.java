package game.rpg;

import java.util.*;

public class View {
	
	public void showName(String name, int no) {
	System.out.println("--- " + name + no + " state ---");	
	}
	
	public void showAttack(String name, int value) {
		System.out.println(name + " Atk:" + value);
	}

	public void showDefend(String name, int value) {
		System.out.println(name + " Def:" + value);
	}

	public void RunAway(String name, int value) {
		System.out.println(name + " Run:" + value);
	}

	public void Chase(String name, int value) {
		System.out.println(name + " Chase:" + value);
	}

	public void GainHP(String name, int value) {
		System.out.println(name + " HP:" + value);
	}

	public void LoseHP(String name, int value) {
		System.out.println(name + " take " + value + " damege");
	}

	public void GainGold(String name, int value) {
		System.out.println(name + " : " + value + " golds");
	}

	public void Die(String name) {
		System.out.println(name + " wasted");
	}

	int damage;
	int hp;
	public void showHeroState(Hero hero) {
		System.out.println("-------------------------");
		this.showAttack(hero.getName(), hero.getAttackPower());
		this.showDefend(hero.getName(), hero.getDefencePower());
		this.RunAway(hero.getName(), hero.getRunPower());
		this.Chase(hero.getName(), hero.getRunPower());
		this.GainHP(hero.getName(), hero.getHp());
		this.LoseHP(hero.getName(), hero.getLoseHP(damage));
		this.GainGold(hero.getName(), hero. getGold());
		hp = hero.getHp();
		if (hp <= 0) {
			this.Die(hero.getName());
		}
		System.out.println("-------------------------");
	}

	public void showMonsterState(Monster monster, int no) {
		System.out.println("-------------------------");
		this.showName(monster.getName(), no);
		this.showAttack(monster.getName(), monster.getAttackPower());
		this.showAttack(monster.getName(), monster.getAttackPower());
		this.showDefend(monster.getName(), monster.getDefencePower());
		this.RunAway(monster.getName(), monster.getRunPower());
		this.Chase(monster.getName(), monster.getRunPower());
		this.GainHP(monster.getName(), monster.getHp());
		this.LoseHP(monster.getName(), monster.getLoseHP(damage));
		this.GainGold(monster.getName(), monster. getGold());
		hp = monster.getHp();
		if (hp <= 0) {
			this.Die(monster.getName());
		}
		System.out.println("-------------------------");
	}
	
	public int selectHeroAction(String[] option) {
		String []str = option;
		System.out.println("(1) " + option[0] + " (2) " + option[1]);
		int select = new Scanner(System.in).nextInt();
		select--;
		if (option[0] == str[select]) {
			return 1;
		}
		return 2;
	}
}
