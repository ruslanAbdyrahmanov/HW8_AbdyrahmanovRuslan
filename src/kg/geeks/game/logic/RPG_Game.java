package kg.geeks.game.logic;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss(2000, 50, "Lord");
        Warrior warrior = new Warrior(290, 10, "Ahiles");
        Medic doc = new Medic(250, 5, 15, "Mudrec");
        Magic magic = new Magic(280, 20, "Hendolf");
        Berserk berserk = new Berserk(270, 10, "Ragnar");
        Medic assistant = new Medic(300, 5, 5, "Estes");
        Hero[] heroes = {warrior, doc, magic, berserk, assistant};

        showStatistics(boss, heroes);
        while (!isGameFinish(boss, heroes)){
            playRound(boss,heroes);
        }
    }

    private static void showStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " ----------------------------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes){
        roundNumber++;
        boss.chooseDefence(heroes);
        boss.hit(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth() > 0 && boss.getHealth() > 0 && heroes[i].getAbility() != boss.getDefence())
            heroes[i].hit(boss);
            heroes[i].applySuperPower(boss, heroes);
        }
        showStatistics(boss, heroes);
    }

    private static boolean isGameFinish(Boss boss, Hero[] heroes) {
        if(boss.getHealth() <=0){
            System.out.println("Heroes WIN!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth() > 0){
                allHeroesDead = false;
                break;
            }
        }
        if(allHeroesDead){
            System.out.println("Boss WIN!!!");
        }
        return allHeroesDead;
    }
}

