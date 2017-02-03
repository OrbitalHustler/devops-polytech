package fr.unice.polytech.qgl.qbd.actions;


import fr.unice.polytech.qgl.qbd.results.FlyResult;

public class FlyAction extends Action {
    public FlyAction() {
        super(NAME.FLY);
    }

    @Override
    public FlyResult createResult(String JSONResult) {
        return new FlyResult(this, JSONResult);
    }
}
