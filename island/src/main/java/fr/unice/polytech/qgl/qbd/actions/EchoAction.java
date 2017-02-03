package fr.unice.polytech.qgl.qbd.actions;

import fr.unice.polytech.qgl.qbd.gameObject.Direction;
import fr.unice.polytech.qgl.qbd.results.EchoResult;

/**
 * PolyTech Nice / SI3 / Module POO-Java
 * Annee 2015 - qbd - Lab 3
 * Package fr.unice.polytech.qgl.qbd.actions
 *
 * @author Flavian Jacquot
 * @version 30/11/2015
 * @since 1.8.0_60
 */
public class EchoAction extends Action {
    private Direction direction;

    public EchoAction(Direction direction) {
        super(NAME.ECHO, "direction", direction.toString());
        this.direction = direction;
    }
    public Direction getDirection(){
        return direction;
    }

    @Override
    public EchoResult createResult(String JSONResult) {
        return new EchoResult(this, JSONResult);
    }
}
