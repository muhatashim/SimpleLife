package org.virus.life.methods;

import org.virus.life.interfaces.Locatable;
import org.virus.life.wrappers.Tile;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: VOLT
 * Date: 2/22/13
 * Time: 5:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class Utils {
    private static final Random random = new Random();

    public static int random(int min, int max) {
        if (max == 0 || max < min)
            return 0;
        try {
            Thread.sleep(random.nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return random.nextInt(max) + min;
    }

    public static boolean random(int chance) {
        return random(0, 100) < chance;
    }

    public static double distance(Locatable l1, Locatable l2) {
        return Math.abs(l2.getLocation().getX() - l1.getLocation().getX()) + Math.abs(l2.getLocation().getY() - l1.getLocation().getY());
    }

    public static Tile midpoint(Locatable l1, Locatable l2) {
        return new Tile((l2.getLocation().getX() + l1.getLocation().getX()) / 2, (l2.getLocation().getY() + l1.getLocation().getY()) / 2);
    }
}
