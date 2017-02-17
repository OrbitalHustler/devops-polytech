package fr.unice.polytech.qgl.qbd.gameObject.map;

import fr.unice.polytech.qgl.qbd.gameObject.Direction;

/**
 * PolyTech Nice / SI3 / Module POO-Java
 * Annee 2015 - qbd - Lab 3
 * Package fr.unice.polytech.qgl.qbd.gameObject.map
 *
 * @author Flavian Jacquot
 * @version 22/12/2015
 * @since 1.8.0_60
 */
public class Coords {
    public final int x;
    public final int y;

    @Override
    public String toString() {
        return "Coords{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coords coords = (Coords) o;
        return x == coords.x && y == coords.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31000 * result + y;
        return result;
    }

    public Coords(int x, int y) {
        this.y = y;
        this.x = x;
    }

    public Coords add(Coords coords) {
        return new Coords(x + coords.x, y + coords.y);
    }
    public Coords add(int x, int y){
        return new Coords(this.x + x, this.y + y);
    }

}
