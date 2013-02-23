package org.virus.life.creatures;

import org.virus.life.wrappers.Grid;
import org.virus.life.wrappers.Tile;
import org.virus.life.wrappers.Traits;
import org.virus.life.wrappers.Creature;

/**
 * Created with IntelliJ IDEA.
 * User: VOLT
 * Date: 2/22/13
 * Time: 5:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class Mouse extends Creature {
    public Mouse(Tile location, Grid grid) {
        super(new Traits[]{Traits.WALKING, Traits.BOTTLES, Traits.CRUNCHY, Traits.CRUNCHY2, Traits.BONEY2,
                Traits.MUSIC, Traits.TENDER, Traits.SOFT, Traits.HARD2, Traits.CRUNCHY2, Traits.BONEY}, location, grid);
    }
}
