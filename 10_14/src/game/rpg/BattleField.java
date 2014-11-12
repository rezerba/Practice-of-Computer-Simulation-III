package game.rpg;

public class BattleField {
	
	int state = 0;
	void showState(Hero hero, Monster monster) {
		System.out.println(hero.name + "�̏��");
		if (hero.hp <= 0) {
			System.out.println("hp:" + 0);
		}
		else {
			System.out.println("HP:" + hero.hp);
		}
		System.out.println("Gold:" + hero.gold);
		System.out.println("maxHP:" + hero.maxHP);
		System.out.println("attackPower:" + hero.attackPower);
		System.out.println("defencePower:" + hero.defencePower);
		System.out.println("runPower:" + hero.runPower);
		System.out.println("******************");
		
		System.out.println(monster.name + "�̏��");
		if (monster.hp <= 0) {
			System.out.println("Hp:" + 0);
		}
		else {
			System.out.println("HP:" + monster.hp);
		}
		System.out.println("Gold:" + monster.gold);
		System.out.println("maxHP:" + monster.maxHP);
		System.out.println("attackPower:" + monster.attackPower);
		System.out.println("defencePower:" + monster.defencePower);
		System.out.println("runPower:" + monster.runPower);
		System.out.println("******************");
	}
	
	boolean buttle(Hero hero, Monster monster) {
		int damage;
		int hrun, mrun;
		state = 0;
		while (true) {
			hero.selectAction();
			hrun = hero.run();
			mrun = monster.run();
			if ((hero.act == 2 && (hrun > mrun ))) {
				System.out.println(hero.name + "�͓����ɐ��������B");
				state = 3;
				return true;
			}
			if ((hero.act == 2 && (hrun < mrun))) {
				System.out.println(hero.name + "�͓����Ɏ��s����");
			}
			
			System.out.println(hero.name + "�̍U��");
			int atk = hero.attack();
			int def = monster.defend();
			damage = atk - def;
			if (damage < 0) {
				damage = 0;
			}
			monster.loseHP(damage);
			
			if (monster.hp <= 0) {
				hero.gold += monster.die();
				System.out.println(monster.name +" hp:" + 0);
				System.out.println(monster.name + "��|�����B");
				hero.gainGold(monster.gold);
				state = 1;
				return true;
			}
			
			monster.act = monster.selectAction();
			if ((monster.act == 2 && (mrun > hrun))) {
				System.out.println(monster.name + "�͓����o�����B");
				state = 4;
				return true;
			}
			if(monster.act == 2 && (hrun > mrun)){
				System.out.println(monster.name + "�͓����Ɏ��s����");
			}
			
			System.out.println(monster.name + "�̍U��");
			atk = monster.attack();
			def = hero.defend();
			damage = atk - def;
			if (damage < 0) {
				damage = 0;
			}
			System.out.println(hero.name + "��" + damage + "�̃_���[�W");
			hero.loseHP(damage);
			
			showState(hero, monster);
			
			if (hero.hp <= 0) {
				System.out.println(hero.name + "�͗͐s�����B");
				
				hero.die();
				state = 2;
				return true;
			}
		}
	}
	
	public void start() {
		Hero hero = new Hero("�߂����낤");
		Monster monster = new Monster();
		boolean flag = false;
		
		flag = buttle(hero, monster);
		while (state != 2) {
			if (flag) {
				Monster monster1 = new Monster();
				flag = buttle(hero, monster1);
			}
		}
	}
	
	public static void main(String[] args) {
		BattleField bf = new BattleField();
		bf.start();
	}
}
