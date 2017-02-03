package fr.unice.polytech.qgl.qbd.behavior;

import fr.unice.polytech.qgl.qbd.GameState;
import fr.unice.polytech.qgl.qbd.results.Result;

public class SecurityBehavior extends Behavior {
    private Behavior behavior;
    private final int ACTION_POINTS_LIMIT = 100;

    public SecurityBehavior(GameState game, Behavior behavior) {
        super(game);
        this.behavior = behavior;
    }

    @Override
    public void makeAction() {
        //TODO Condition d'arrêt X points d'action
        behavior.makeAction();
    }

    @Override
    public Behavior acknowledgeResults(Result result) {
        behavior = behavior.acknowledgeResults(result);
        return this;
    }
}
