package game.rpg;

public class Monster extends GameChara{
	private int act;
	
	Monster(View view) {
		super(view);
		this.name = "Monster";
		this.maxHP = ran.nextInt(81) + 20;
		this.hp = ran.nextInt(this.maxHP + 1) + 20;
		this.gold = ran.nextInt(91) + 10;
		this.attackPower = ran.nextInt(91) + 10;
		this.defencePower = ran.nextInt(91) + 10;
		this.runPower = ran.nextInt(91) + 10;
		this.act = ran.nextInt(3) + 1;
	}
	
	int selectAction() {
		return  this.act;
	}
}
