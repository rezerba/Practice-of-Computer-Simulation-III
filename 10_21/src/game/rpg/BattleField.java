package game.rpg;

import java.util.Scanner;

public class BattleField {
	
	private int state = 0;
	void showState(Hero hero, Monster monster) {
		System.out.println(hero.getName() + "�̏��");
		if (hero.getHp() <= 0) {
			System.out.println("hp:" + 0);
		}
		else {
			System.out.println("HP:" + hero.getHp());
		}
		System.out.println("Gold:" + hero.getGold());
		System.out.println("maxHP:" + hero.getMaxHP());
		System.out.println("attackPower:" + hero.getAttackPower());
		System.out.println("defencePower:" + hero.getDefencePower());
		System.out.println("runPower:" + hero.getRunPower());
		System.out.println("******************");
		
		System.out.println(monster.getName() + "�̏��");
		if (hero.getHp() <= 0) {
			System.out.println("Hp:" + 0);
		}
		else {
			System.out.println("HP:" + monster.getHp());
		}
		System.out.println("Gold:" + monster.getGold());
		System.out.println("maxHP:" + monster.getMaxHP());
		System.out.println("attackPower:" + monster.getAttackPower());
		System.out.println("defencePower:" + monster.getDefencePower());
		System.out.println("******************");
	}
	
	boolean buttle(Hero hero, Monster monster) {
		int damage;
		int hrun, mrun;
		state = 0;
		
		while (true) {
			System.out.println("select action (1)attack (2)run");
			hero.selectAction();
			hrun = hero.run();
			mrun = monster.run();
			if ((hero.getAct() == 2 && (hrun > mrun ))) {
				System.out.println(hero.getName() + "�͓����ɐ��������B");
				state = 3;
				return true;
			}
			if ((hero.getAct() == 2 && (hrun < mrun))) {
				System.out.println(hero.getName() + "�͓����Ɏ��s����");
			}
			
			System.out.println(hero.getName() + "�̍U��");
			int atk = hero.attack();
			int def = monster.defend();
			damage = atk - def;
			if (damage < 0) {
				damage = 0;
			}
			monster.loseHP(damage);
			
			if (monster.getHp() <= 0) {
				System.out.println(monster.getName() +" hp:" + 0);
				System.out.println(monster.getName() + "��|�����B");
				hero.gainGold(monster.die());
				state = 1;
				return true;
			}
			monster.selectAction();
			if ((monster.getAct() == 2 && (mrun > hrun))) {
				System.out.println(monster.getName() + "�͓����o�����B");
				state = 4;
				return true;
			}
			if(monster.getAct() == 2 && (hrun > mrun)){
				System.out.println(monster.getName() + "�͓����Ɏ��s����");
			}
			
			System.out.println(monster.getName() + "�̍U��");
			atk = monster.attack();
			def = hero.defend();
			damage = atk - def;
			if (damage < 0) {
				damage = 0;
			}
			System.out.println(hero.getName() + "��" + damage + "�̃_���[�W");
			hero.loseHP(damage);
			
			showState(hero, monster);
			
			if (hero.getHp() <= 0) {
				System.out.println(hero.getName() + "�͗͐s�����B");
				
				hero.die();
				state = 2;
				return true;
			}
		}
	}
	
	public int repeatBattle(Hero hero, Monster monster) {
		System.out.println("select action (1)attack (2)end");
		int act = new Scanner(System.in).nextInt();
		if (act == 1) {
			state = 0;
			buttle(hero, monster);
		}
		else {
			state = 2;
		}
		return state;
	}
	
	public void start() {
		Hero hero = new Hero("�߂����낤");
		Monster monster = new Monster();
		boolean flag = false;
		
		flag = buttle(hero, monster);
		while (state != 2) {
			Monster monster1 = new Monster();
			state = repeatBattle(hero, monster1);
		}
	}
	
	public static void main(String[] args) {
		BattleField bf = new BattleField();
		bf.start();
	}
}
