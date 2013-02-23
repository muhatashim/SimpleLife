package org.virus.life.wrappers;

import org.virus.life.methods.Utils;

/**
 * Created with IntelliJ IDEA.
 * User: VOLT
 * Date: 2/22/13
 * Time: 5:17 AM
 * To change this template use File | Settings | File Templates.
 */
public enum Traits {
    FLYING(Type.ABILITY),
    WALKING(Type.ABILITY),
    COMPUTERS(Type.LIKE),
    BOTTLES(Type.LIKE),
    HUMIDIFIERS(Type.LIKE),
    CD_PLAYERS(Type.LIKE),
    MUSIC(Type.LIKE),
    TAYLOR_SWIFT(Type.LIKE),
    KEYBOARDS(Type.LIKE),
    HOT_CHEETOS(Type.LIKE),
    CAPS_LOCK(Type.LIKE),
    TENDER(Type.TASTE),
    TENDER2(Type.TASTE_LIKE),
    SPICY(Type.TASTE),
    SPICY2(Type.TASTE_LIKE),
    SWEET(Type.TASTE),
    SWEET2(Type.TASTE_LIKE),
    FEATHERY(Type.TASTE),
    FEATHERY2(Type.TASTE_LIKE),
    METALLIC(Type.TASTE),
    METALLIC2(Type.TASTE_LIKE),
    SOFT(Type.TASTE),
    SOFT2(Type.TASTE_LIKE),
    HARD(Type.TASTE),
    HARD2(Type.TASTE_LIKE),
    CRUNCHY(Type.TASTE),
    CRUNCHY2(Type.TASTE_LIKE),
    BOMBASTIC(Type.TASTE),
    BOMBASTIC2(Type.TASTE_LIKE),
    BONEY(Type.TASTE),
    BONEY2(Type.TASTE_LIKE);
    private final Type type;
    int dominance;

    Traits(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public int getDominance() {
        return dominance;
    }

    public boolean isDominantOver(Traits trait) {
        return compare(trait) > 0;
    }

    public Traits randomBest(Traits trait) {
        int myDom = getDominance();
        int max = trait.getDominance() + myDom;
        return Utils.random(0, max) < myDom ? this : trait;
    }

    public void updateDominance(int dominanceChange) {
        dominance += dominanceChange;
    }

    public int compare(Traits t) {
        return getDominance() - t.getDominance();
    }

    public enum Type {
        ABILITY, TASTE, TASTE_LIKE, LIKE
    }
}
