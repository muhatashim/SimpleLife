package org.virus.life;

import org.virus.life.creatures.*;
import org.virus.life.methods.Utils;
import org.virus.life.wrappers.Creature;
import org.virus.life.wrappers.Grid;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: VOLT
 * Date: 2/22/13
 * Time: 5:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static Grid grid;
    public static List<Creature> creatureList;
    public static GUI gui;

    public static void main(String[] args) {
        creatureList = new ArrayList();
        grid = new Grid(400, creatureList);

        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    gui = new GUI();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 2000; i++) {
            Creature type;
            switch (Utils.random(0, 7)) {
                default:
                    type = null;
                    break;
                case 1:
                    type = new Falcon(grid.getRandomLocation(), grid);
                    break;
                case 2:
                    type = new Frog(grid.getRandomLocation(), grid);
                    break;
                case 3:
                    type = new Lion(grid.getRandomLocation(), grid);
                    break;
                case 4:
                    type = new Mouse(grid.getRandomLocation(), grid);
                    break;
                case 5:
                    type = new Snake(grid.getRandomLocation(), grid);
                    break;
                case 6:
                    type = new Sponge(grid.getRandomLocation(), grid);
            }
            if (type == null)
                continue;

            creatureList.add(type);
        }

        for (int i = 0; i < 10000; i++) {
            grid.step();
        }
    }
}
