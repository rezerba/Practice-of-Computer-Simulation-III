package game.rpg;

public class BattleField {
	
	private int state = 0;
	private String []actions = {"battle", "end"};
	private String []stateSt = {"戦闘中", "プレイヤ勝利", "プレイヤ負け", "プレイヤ逃走", "敵キャラ逃走"};
	Hero hero;
	Monster monster;
	View view;
	
	BattleField(Hero hero, View view) {
		this.hero = hero;
		this.view = view;
	}
	
	boolean buttle() {
		int damage;
		int hrun, mrun;
		state = 0;
		
		while (true) {
			hero.selectHeroAction();
			hrun = hero.run();
			mrun = monster.run();
			if ((hero.getAct() == 2 && (hrun > mrun ))) {
				view.selectHeroAction(actions);
				return true;
			}
			
			// heroの攻撃
			int atk = hero.attack();
			int def = monster.defend();
			damage = atk - def;
			if (damage < 0) {
				damage = 0;
			}
			monster.loseHP(damage);
			
			if (monster.getHp() <= 0) {
				hero.gainGold(monster.die());
				state = 1;
				return true;
			}
			
			showCharacterState();
			
			// monsterの攻撃
			monster.selectAction();
			if ((monster.getAct() == 2 && (mrun > hrun))) {
				state = 4;
				return true;
			}
			
			atk = monster.attack();
			def = hero.defend();
			damage = atk - def;
			if (damage < 0) {
				damage = 0;
			}
			hero.loseHP(damage);
			
			showCharacterState();
			
			if (hero.getHp() <= 0) {
				hero.die();
				state = 2;
				return true;
			}
		}
	}
	
	public int repeatBattle() {
		boolean flag = false;
		while ((!flag)) {
			this.monster = new Monster();
			flag = buttle();
		}
		return state;
	}
	
	public void start() {
		this.monster = new Monster();
		while (state != 2) {
			state = view.selectHeroAction(actions);
			if (state == 2) {
				break;
			}
			repeatBattle();
		}
	}
	
	public String[] getStateSt() {
		return stateSt;
	}
	
	void showCharacterState() {
		view.showHeroState(hero);
		view.showMonsterState(monster);
	}
}
