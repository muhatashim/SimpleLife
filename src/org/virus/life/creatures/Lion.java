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
public class Lion extends Creature {
    public Lion(Tile location, Grid grid) {
        super(new Traits[]{Traits.WALKING, Traits.HUMIDIFIERS, Traits.TAYLOR_SWIFT, Traits.SPICY, Traits.SPICY2, Traits.BONEY, Traits.BONEY2,
                Traits.BOMBASTIC, Traits.SWEET2}, location, grid);
    }
}
