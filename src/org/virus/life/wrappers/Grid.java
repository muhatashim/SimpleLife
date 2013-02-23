package org.virus.life.wrappers;

import org.virus.life.data.Environment;
import org.virus.life.interfaces.Locatable;
import org.virus.life.methods.Utils;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: VOLT
 * Date: 2/22/13
 * Time: 6:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class Grid {
    private final List<Creature> creatures;
    private final int size;

    public Grid(int size, List<Creature> creatures) {
        this.creatures = creatures;
        this.size = size;
    }

    public void step() {
        Creature[] creatureArray = new Creature[creatures.size()];
        creatures.toArray(creatureArray);
        for (Creature creature : creatureArray) {
            creature.run();
        }
        System.gc();
    }

    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("Segoe UI", 0, 10));
        Creature[] creatureArray = new Creature[creatures.size()];
        creatures.toArray(creatureArray);
        for (Creature creature : creatureArray) {
            if (creature != null) {
                Tile l = creature.getLocation();
                Traits[] traits = creature.getTraits();
                int dom = 0;
                for (Traits tr : traits) {
                    dom += tr.dominance;
                }
                g.drawString("" + dom, l.getX(), l.getY());
                for (Creature creature2 : creatureArray) {
                    if (creature.distanceTo(creature2) < Environment.INTERACTION_RANGE) {
                        g.drawLine(l.getX(), l.getY(), creature2.getLocation().getX(), creature2.getLocation().getY());
                    }
                }
            }
        }
        g.drawString("Population: " + creatureArray.length, 300, 300);
        Traits[] values = Traits.values();
        Arrays.sort(values, new Comparator<Traits>() {
            @Override
            public int compare(Traits o1, Traits o2) {
                return o2.dominance - o1.dominance;
            }
        });
        g.drawString("Trait Dominance: " + Arrays.toString(values), 150, 312);
    }

    public Tile getRandomLocation() {
        return new Tile(Utils.random(0, size), Utils.random(0, size));
    }

    public List<Tile> getAdjacentLocations(Locatable locatable) {
        List<Tile> adjs = new ArrayList();
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x != 0 || y != 0) {
                    Tile derived = locatable.getLocation().derive(x, y);
                    if (isValid(derived))
                        adjs.add(derived);
                }
            }
        }
        return adjs;
    }

    public boolean isValid(Tile tile) {
        return tile.getX() >= 0 && tile.getY() >= 0 && tile.getX() < size && tile.getY() < size;
    }

    public int getSize() {
        return size;
    }

    public List<Creature> getCreatures() {
        return creatures;
    }
}
