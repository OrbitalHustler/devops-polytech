package fr.unice.polytech.qgl.qbd.results;

import fr.unice.polytech.qgl.qbd.actions.StopAction;

public class StopResult extends Result{
    private StopAction action;

    public StopResult(StopAction action, String JSONResult){
        super(JSONResult);
        this.action = action;
    }
    @Override
    public StopAction getAction() {
        return action;
    }
}
