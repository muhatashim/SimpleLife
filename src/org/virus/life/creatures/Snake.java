package org.virus.life.creatures;

import org.virus.life.wrappers.Grid;
import org.virus.life.wrappers.Tile;
import org.virus.life.wrappers.Traits;
import org.virus.life.wrappers.Creature;

/**
 * Created with IntelliJ IDEA.
 * User: VOLT
 * Date: 2/22/13
 * Time: 5:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class Snake extends Creature {
    public Snake(Tile location, Grid grid) {
        super(new Traits[]{Traits.MUSIC, Traits.WALKING, Traits.TAYLOR_SWIFT, Traits.KEYBOARDS, Traits.HOT_CHEETOS, Traits.BOMBASTIC,
                Traits.SOFT, Traits.SOFT2, Traits.BONEY, Traits.BOTTLES, Traits.TENDER, Traits.TENDER2}, location, grid);
    }
}
