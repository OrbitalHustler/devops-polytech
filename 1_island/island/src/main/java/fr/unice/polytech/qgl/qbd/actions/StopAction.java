package fr.unice.polytech.qgl.qbd.actions;

import fr.unice.polytech.qgl.qbd.results.StopResult;

/**
 * PolyTech Nice / SI3 / Module POO-Java
 * Annee 2015 - qbd - Lab 3
 * Package fr.unice.polytech.qgl.qbd.actions
 *
 * @author Flavian Jacquot
 * @version 28/11/2015
 * @since 1.8.0_60
 */
public class StopAction extends Action {
    public StopAction() {
        super(NAME.STOP);
    }

    @Override
    public StopResult createResult(String JSONResult) {
        return new StopResult(this, JSONResult);
    }
}
