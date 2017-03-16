package fr.unice.polytech.qgl.qbd.exception;

import fr.unice.polytech.qgl.qbd.gameObject.map.Coords;

public class OutsideMapBoundariesException extends RuntimeException {
    public OutsideMapBoundariesException(Coords c){
        super(
                "attempted to go outside the boundaries of the map; x = "
                + c.x + "; y = " + c.y
        );
    }
}
