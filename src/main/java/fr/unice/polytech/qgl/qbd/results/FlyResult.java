package fr.unice.polytech.qgl.qbd.results;

import fr.unice.polytech.qgl.qbd.actions.FlyAction;

public class FlyResult extends Result{
    private FlyAction action;

    public FlyResult(FlyAction action, String JSONResult){
        super(JSONResult);
        this.action = action;
    }
    @Override
    public FlyAction getAction() {
        return action;
    }
}
