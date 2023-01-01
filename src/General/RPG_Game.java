package General;

import Players.*;

import java.util.Random;

public class RPG_Game {
    public static int round_number = 1;
    public static Random random = new Random();
    public static int heroesAttack;
    private static int SuperAbility;


    public static void start() {
        Boss boss = new Boss(700, 50);
        Warrior warrior = new Warrior(270, 15, "Воин1");
        Medic doc = new Medic(220, 5, "Doc", 15);
        Magic magic = new Magic(240, 20, "magic");
        Bersek bersek = new Bersek(300, 20, "bersek");
        Medic assistant = new Medic(250, 10, "assistant", 5);
        Hero heroes[] = {warrior, doc, magic, bersek, assistant};
        printStatistics(heroes, boss);
        while (!isGameFinished(heroes, boss)){
            round(heroes, boss);
        }
    }

    private static void printStatistics(Hero heroes[], Boss boss) {
        System.out.println("-------ROUND " + round_number + " -------");
        System.out.println("Boss health: " + boss.getHealth() + " [ " + boss.getDamage() + " ] "+
                " { "+heroesAttack+ " }");
        for (Hero currentHero : heroes) {
            System.out.println(currentHero.getName() + " Health: " + currentHero.getHealth() +
                    " [ " + currentHero.getDamage() + " ] "+ " { "+heroesAttack+" } ");

        }
        System.out.println("Warrior applied a: "+ Players.SuperAbility.CRITICAL_DAMAGE+
                " [ "+ SuperAbility + " ] ");
    }

    private static void bossHits(Hero[] heroes, Boss boss, Bersek bersek) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
           if (bersek.getHealth() >0 && boss.getDamage() > 0){
               bersek.setHealth(bersek.getHealth() - boss.getDamage());
           }
        }

    }

    private static void heroesHits(Hero[] heroes, Boss boss, Bersek bersek) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
            if (bersek.getHealth() > 0 && boss.getHealth() > 0){
                boss.setHealth(boss.getHealth() - bersek.getDamage());
            }

        }

    }

    private static void applySuperAbilities(Hero heroes[], Boss boss, Magic magic) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 ) {
                heroes[i].applySuperAbility(boss, heroes);
            }

        }
    }

    private static boolean isGameFinished(Hero[] heroes, Boss boss) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!");
        }
        return allHeroesDead;
    }
    private static void round(Hero heroes[], Boss boss){
        round_number++;
        Random random1 = new Random(heroesAttack++);
        Random random2 = new Random(SuperAbility++);
        bossHits(heroes,boss, new Bersek(300, 20, "bersek"));
        heroesHits(heroes, boss,new Bersek(300, 20, "bersek"));
        applySuperAbilities(heroes, boss, new Magic(240, 20, "magic"));
        printStatistics(heroes, boss);
    }
    }


