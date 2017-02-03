package fr.unice.polytech.qgl.qbd.results;

import fr.unice.polytech.qgl.qbd.actions.HeadingAction;

public class HeadingResult extends Result {
    private HeadingAction action;
    public HeadingResult(HeadingAction action, String JSONResult){
        super(JSONResult);
        this.action = action;
    }
    @Override
    public HeadingAction getAction() {
        return action;
    }
}
