package game.rpg;

public class Main {

	public static void main(String[] args) {
		View view = new View();
		Hero hero = new Hero("�߂����낤", view);
		BattleField bf = new BattleField(hero, view);
		bf.start();
	}
}
