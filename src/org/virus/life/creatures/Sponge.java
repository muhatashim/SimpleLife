package org.virus.life.creatures;

import org.virus.life.wrappers.Creature;
import org.virus.life.wrappers.Grid;
import org.virus.life.wrappers.Tile;
import org.virus.life.wrappers.Traits;

/**
 * Created with IntelliJ IDEA.
 * User: VOLT
 * Date: 2/22/13
 * Time: 7:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class Sponge extends Creature {
    public Sponge(Tile location, Grid grid) {
        super(new Traits[]{Traits.SOFT, Traits.BOMBASTIC, Traits.BONEY, Traits.CAPS_LOCK, Traits.BOTTLES, Traits.BONEY2, Traits.TENDER2}, location, grid);
    }
}
