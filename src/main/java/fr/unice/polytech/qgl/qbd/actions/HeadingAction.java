package fr.unice.polytech.qgl.qbd.actions;

import fr.unice.polytech.qgl.qbd.gameObject.Direction;
import fr.unice.polytech.qgl.qbd.results.HeadingResult;

public class HeadingAction extends Action {
    private Direction direction;

    public HeadingAction(Direction direction) {
        super(NAME.HEADING, "direction", direction.toJSONString());
        this.direction = direction;
    }
    public Direction getDirection(){
        return direction;
    }

    @Override
    public HeadingResult createResult(String JSONResult) {
        return new HeadingResult(this, JSONResult);
    }
}
