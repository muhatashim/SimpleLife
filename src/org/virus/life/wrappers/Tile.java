package org.virus.life.wrappers;

import org.virus.life.interfaces.Locatable;

/**
 * Created with IntelliJ IDEA.
 * User: VOLT
 * Date: 2/22/13
 * Time: 6:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class Tile implements Locatable {
    private int x;
    private int y;

    @Override
    public String toString() {
        return "Tile{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tile tile = (Tile) o;

        if (x != tile.x) return false;
        if (y != tile.y) return false;

        return true;
    }

    public Tile derive(int x, int y) {
        return new Tile(this.x + x, this.y + y);
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {


        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public Tile getLocation() {
        return this;
    }
}
