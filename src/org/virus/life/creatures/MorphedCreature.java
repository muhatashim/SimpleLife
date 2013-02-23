package org.virus.life.creatures;

import org.virus.life.wrappers.Tile;
import org.virus.life.wrappers.Traits;
import org.virus.life.wrappers.Creature;
import org.virus.life.wrappers.Grid;

/**
 * Created with IntelliJ IDEA.
 * User: VOLT
 * Date: 2/22/13
 * Time: 5:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class MorphedCreature extends Creature {
    public MorphedCreature(Traits[] traits, Tile location, Grid grid, Creature[] parents) {
        super(traits, location, grid, parents);
    }
}
