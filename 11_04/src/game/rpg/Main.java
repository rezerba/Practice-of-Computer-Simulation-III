package game.rpg;

public class Main {

	public static void main(String[] args) {
		View view = new View();
		Hero hero = new Hero("‚ß‚¢‚¶‚ë‚¤", view);
		BattleField bf = new BattleField(hero, view);
		bf.start();
	}
}
