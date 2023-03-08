package Algorithmics.homework;

import java.util.Random;

/**
 * Задача 4. Подземелье [4] <p>
 * Для прохождения подземелья герою нужно убить всех монстров на пути. <p>
 * У каждого монстра есть параметр здоровья - сколько урона может выдержать монстр при битве. <p>
 * Также у героя есть два параметра: выносливость и сила. <p>
 * Выносливость отвечает за количество ударов, которые герой может нанести за прохождение подземелья, а сила отвечает за урон от одного удара по монстру. <p>
 * Герой может прокачать несколько уровней, на каждом уровне урон героя увеличивается на 1 единицу. <p>
 * Выносливость при этом не меняется и для каждого уровня равна числу M. <p>
 * Определите, какое минимальное количество уровней надо получить герою перед походом в подземелье, если первоначально герой нулевого уровня и имеет 0 урона. <p>
 * В первой строке даны числа N (1 < N < 10^5) и M (1 < M < 10^18) - количество монстров в подземелье и выносливость персонажа соответственно. <p>
 * В следующей строке записано N целых чисел - здоровье каждого монстра в подземелье. <p>
 * Выведите на экран минимально возможное количество уровней, которые придется получить герою, чтобы успешно пройти этот данж.
 */


public class Dungeon {
    private static final int stamina = 1_000_000;
    private static final int numberOfMonstersInDungeon = 1_000_000; // N (1 < N < 10^5)
    private static final int[] monsters = new int[numberOfMonstersInDungeon];

    public static void main(String[] args) {
        int maxHp = 50;
        for (int i = 0; i < monsters.length; i++) {
            monsters[i] = new Random().nextInt(1, maxHp + 1);
        }
        long start = System.currentTimeMillis();
        int level = findMinLevel();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(level);

    }

    private static int findMinLevel() {
        int level = 1;
        boolean isPassed = false;

        while (!isPassed) {
            int staminaHero = stamina;

            for (int monster : monsters) {
                staminaHero -= Math.ceil((double) monster / level);

                if (staminaHero < 0) {
//                    level++;
                    level -= staminaHero;
                    break;
                }
            }

            if (staminaHero >= 0) {
                isPassed = true;
            }
        }

        return level;
    }
}
