package game.rpg;

public class Hero extends GameChara{
	private String actions[] = {"attack", "runAway"};

	Hero(String name, View view) {
		super(view);
		this.name = name;
		this.hp = 100;
		this.maxHP = 100;
		this.gold = 10000;
		this.attackPower = 100;
		this.defencePower = 100;
	}
	
	int selectAction() {
		int action = view.selectHeroAction(this.actions);
		return action;
	}
}
