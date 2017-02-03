package fr.unice.polytech.qgl.qbd.behavior;

import fr.unice.polytech.qgl.qbd.GameState;
import fr.unice.polytech.qgl.qbd.results.Result;

/**
 * Abstract class to extend from
 * Describe a specific Behavior (explore, collect ...)
 */
public abstract class Behavior {
    protected GameState game;

    public Behavior(GameState game) {
        this.game = game;
    }

    public abstract void makeAction();
    public abstract Behavior acknowledgeResults(Result result);
}
