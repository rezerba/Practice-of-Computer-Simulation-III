package game.rpg;

public class BattleField {
	
	private int state = 0;
	private int no = 0;
	private String []actions = {"battle", "end"};
	private String []stateSt = {"í“¬’†", "ƒvƒŒƒCƒ„Ÿ—˜", "ƒvƒŒƒCƒ„•‰‚¯", "ƒvƒŒƒCƒ„“¦‘–", "“GƒLƒƒƒ‰“¦‘–"};
	GameChara hero;
	GameChara monster;
	View view;
	
	BattleField(GameChara hero, View view) {
		this.hero = hero;
		this.view = view;
	}
	
	boolean buttle() {
		int damage;
		int hrun, mrun;
		state = 0;
		
		while (true) {
			hrun = hero.run();
			mrun = monster.run();
			if ((hero.selectAction() == 2 && (hrun > mrun ))) {
				state = 4;
				return true;
			}
			
			// hero‚ÌUŒ‚
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
			
			// monster‚ÌUŒ‚
			if ((monster.selectAction() == 2 && (mrun > hrun))) {
				state = 5;
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
			no++;
			this.monster = makeNewMonster(no);
			flag = buttle();
		}
		return state;
	}
	
	public void start() {
		this.monster = makeNewMonster(no);
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
		view.showMonsterState(monster, no);
	}
	
	GameChara makeNewMonster(int no) {
		double ran = Math.random();
		if (ran <= 0.3) {
			this.monster = new MagicMonster(view);
		}
		this.monster = new Monster(view);
		return monster;
	}
}
