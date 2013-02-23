package org.virus.life.wrappers;

import org.virus.life.creatures.MorphedCreature;
import org.virus.life.data.Environment;
import org.virus.life.interfaces.Locatable;
import org.virus.life.methods.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: VOLT
 * Date: 2/22/13
 * Time: 5:17 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Creature implements Runnable, Locatable {
    private static float nextId = 0;
    private final Traits[] traits;
    private final float id;
    private final Grid grid;
    private final Creature[] parents;
    private Tile location;

    public Creature(Traits[] traits, Tile location, Grid grid) {
        this(traits, location, grid, null);
    }

    public Creature(Traits[] traits, Tile location, Grid grid, Creature[] parents) {
        this.traits = traits;
        this.location = location;
        this.grid = grid;
        this.parents = parents;
        id = nextId++;
    }

    public final Tile getLocation() {
        return location;
    }

    public final void setLocation(Tile location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Creature creature = (Creature) o;

        if (Float.compare(creature.id, id) != 0) return false;

        return true;
    }

    @Override
    public final int hashCode() {
        return (id != +0.0f ? Float.floatToIntBits(id) : 0);
    }

    public final float getId() {
        return id;
    }

    public final Traits[] getTraits() {
        return traits;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "location=" + location +
                ", traits=" + (traits == null ? null : Arrays.asList(traits)) +
                '}';
    }

    public final boolean isParent(Creature creature) {
        Creature[] parents1 = creature.getParents();
        if (parents1 == null) {
            return false;
        }
        for (Creature cParent : parents1) {
            if (cParent != null && cParent.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public final boolean willEat(Creature creature) {
        if (creature.equals(this) || isParent(creature))
            return false;

        int similarities = 0, total = 0;
        for (Traits trait : creature.getTraits()) {
            if (trait.getType() == Traits.Type.TASTE) {
                for (Traits myTrait : getTraits()) {
                    if (myTrait.getType() == Traits.Type.TASTE_LIKE) {
                        String name = myTrait.name();
                        similarities += name.substring(0, name.length() - 1).equals(trait.name()) ? 1 : 0;
                    }
                }
                total++;
            }
        }
        return Utils.random(0, total) < similarities;
    }

    public final void eat(Creature creature) {
        for (Traits tr : creature.getTraits()) {
            tr.updateDominance(-1);
        }
        grid.getCreatures().remove(creature);
    }

    public final int[] findSimilarities(Creature creature) {
        int total = 0, similarities = 0;
        boolean loopedMine = false;
        for (Traits traitMate : creature.getTraits()) {
            for (Traits myTrait : getTraits()) {
                if (myTrait == traitMate) {
                    similarities++;
                }
                if (!loopedMine)
                    total += myTrait.getType() == Traits.Type.LIKE ? 1 : 0;
            }
            total += traitMate.getType() == Traits.Type.LIKE ? 1 : 0;
            loopedMine = true;
        }
        return new int[]{similarities, total};
    }

    public final boolean willMate(Creature mate) {
        if (mate.equals(this) || isParent(mate))
            return false;

        int[] similarities = findSimilarities(mate);
        return Utils.random(0, similarities[1]) < similarities[0];
    }

    public final void mate(Creature mate) {
        List<Traits> coolTraits = new ArrayList();
        int max = Math.min(mate.getTraits().length, traits.length);
        for (int i = 0; i < max; i++) {
            Traits newTrait = mate.getTraits()[i].randomBest(traits[i]);
            if (!coolTraits.contains(newTrait)) {
                coolTraits.add(newTrait);
                newTrait.updateDominance(1);
            }
        }
        grid.getCreatures().add(new MorphedCreature(coolTraits.toArray(new Traits[coolTraits.size()]), Utils.midpoint(this, mate), grid,
                new Creature[]{this, mate}));
    }

    public final double distanceTo(Locatable locatable) {
        return Utils.distance(this, locatable);
    }

    public final Creature[] getParents() {
        return parents;
    }

    public final void stepTowards(Locatable loc) {
        List<Tile> adjacentLocations = grid.getAdjacentLocations(this);
        Tile best = null;
        double lowest = Double.MAX_VALUE;
        for (Tile tile : adjacentLocations) {
            double currDist = Utils.distance(tile, loc);
            if (currDist < lowest) {
                best = tile;
                lowest = currDist;
            }
        }
        if (best != null)
            setLocation(best);
    }

    //i know i crap coded this. i felt like screw this project after a while since it started becoming kinda lame to me....
    @Override
    public final void run() {
        Tile randomLocation = grid.getRandomLocation();
        for (Traits trait : traits) {
            if (trait == Traits.FLYING) {
                for (int i = 0; i < 5; i++)
                    stepTowards(randomLocation);
            }
        }
        stepTowards(randomLocation);
        List<Creature> around = new ArrayList<Creature>();
        for (Creature creature : grid.getCreatures()) {
            if (creature == this) {
                continue;
            }
            if (distanceTo(creature) < Environment.INTERACTION_RANGE) {
                around.add(creature);
            }
        }
        if (around.size() >= 3) {
            int best = Integer.MAX_VALUE;
            Creature bestC = null;
            for (Creature creature : around) {
                int curr = 0;
                for (Traits traits1 : creature.getTraits()) {
                    curr += traits1.dominance;
                }
                if (curr < best) {
                    best = curr;
                    bestC = creature;
                }
            }
            if (bestC != null)
                grid.getCreatures().remove(bestC);
            return;
        }

        for (Creature creature : around) {
            if (creature.distanceTo(this) < Environment.INTERACTION_RANGE) {
                if (willEat(creature)) {
                    eat(creature);
                    break;
                }
                if (willMate(creature)) {
                    mate(creature);
                    break;
                }
            }
        }
    }
}
