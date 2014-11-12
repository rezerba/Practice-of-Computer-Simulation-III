package simulation;

import java.util.*;

public class Lottery {
	
	public static int selectKuji(String[] kuji){
		int p = (int)(Math.random()*kuji.length);
		return p;
	}
	
	
	static void showKuji(String[] kuji, double[][] kuji2){
		for(int i = 0; i < kuji.length; i++){
		System.out.println(kuji[i] + " " + (int)kuji2[i][0] + "‰~ Šm—¦" + kuji2[i][1]);
		}
	}
	
	
	static void showKuji(String[] kuji, double[][] kuji2, int x){
		System.out.println("Œ‹‰ÊF" + kuji[x] + " Ü‹à" + (int)kuji2[x][0] + "‰~");
	}
	
	public static int selectKuji(double[][] kuji2) {
		double ran = (Math.random()*1);
		for(int i = 0; i < kuji2.length; i++){
			if(kuji2[i][1] > ran){
				return i;
			}
		}
		return (kuji2.length - 1);
	}
	
	public static int[] buyLottery(double[][] kuji2, int num) {
		int[] anum = new int[num];
		for(int i = 0; i < anum.length; i++) {
			anum[i] = selectKuji(kuji2);
		}
		return anum;
	}
	
	public static int checkout(int[] anum, double[][] kuji2){
		int money = 0;
		for(int i = 0; i < anum.length; i++){
			money += kuji2[anum[i]][0];
		}
		return money;
	}
	
	public static void start(String[] kuji, double[][] kuji2) {
		System.out.println("•ó‚­‚¶ƒQ[ƒ€\n‚P–‡100‰~‚Å‚·");
		showKuji(kuji, kuji2);
		System.out.println("‰½–‡w“ü‚µ‚Ü‚·‚©H");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		//while (scanner.hasNextInt()) {
			if(!(scanner.hasNextInt())) {
				System.out.println("“ü—Í‚³‚ê‚½’l‚ª®”’l‚Å‚Í‚ ‚è‚Ü‚¹‚ñB");
			}
		//}
		scanner.close();
		
		//num = new java.util.Scanner(System.in).nextInt();
		
		int[] anum = buyLottery(kuji2, num);
		int money = checkout(anum, kuji2);
		int nummoney = num * 100;
		System.out.println("w“ü‹àŠzF" + nummoney + "‰~\n" + "‡Œv“–‘I‹àŠzF" + money + "‰~");
	}
	
	public static void main(String[] args) {
		String[] kuji = {"1“™", "2“™", "3“™", "‚Í‚¸‚ê"};
		double[][] kuji2 = {{10000, 0.001},
							{1000, 0.02},
							{100, 0.5},
							{0, 1.0}};
		
		start(kuji, kuji2);
	}
}
