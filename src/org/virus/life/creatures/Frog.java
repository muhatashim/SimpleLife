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
public class Frog extends Creature {
    public Frog(Tile location, Grid grid) {
        super(new Traits[]{Traits.TAYLOR_SWIFT, Traits.WALKING, Traits.KEYBOARDS, Traits.CAPS_LOCK, Traits.HUMIDIFIERS,
                Traits.SWEET, Traits.SOFT, Traits.TENDER, Traits.SOFT2,
                Traits.TENDER2}, location, grid);
    }
}
