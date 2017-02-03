package fr.unice.polytech.qgl.qbd.driver;

import fr.unice.polytech.qgl.qbd.actions.*;
import fr.unice.polytech.qgl.qbd.exception.OutsideMapBoundariesException;
import fr.unice.polytech.qgl.qbd.gameObject.Direction;
import fr.unice.polytech.qgl.qbd.gameObject.map.Coords;

import java.util.LinkedList;

public class DroneDriver extends ActionGenerator{
    private Direction heading;
    private Coords pos;
    private int width;
    private int height;
    private boolean mapBoundariesCheck;

    //DroneDriver temporaire qui ne check pas les bords de carte
    public DroneDriver(LinkedList<Action> actionList, Direction heading){
        super(actionList);
        this.heading = heading;
        pos = new Coords(0, 0);
        mapBoundariesCheck = false;
    }
    public DroneDriver(LinkedList<Action> actionList, Direction heading,
                       Coords position, int width, int height){
        super(actionList);
        this.heading     = heading;
        this.pos = position;
        this.width = width;
        this.height = height;
        mapBoundariesCheck = true;
    }
    public DroneDriver(ActionGenerator ag, Direction heading,
                       Coords position, int width, int height){
        super(ag);
        this.heading     = heading;
        this.pos = position;
        this.width = width;
        this.height = height;
        mapBoundariesCheck = true;
    }
    //Move the coordinates of 1 case into specified direction
    private void move(Direction d){
        switch (d){
            case N:
                pos = pos.add(0, -1);
                break;
            case E:
                pos = pos.add(1, 0);
                break;
            case S:
                pos = pos.add(0, 1);
                break;
            case W:
                pos = pos.add(-1, 0);
                break;
            default:
                break;
        }
        if (mapBoundariesCheck &&
                (pos.x < 0 || pos.x > width - 1 || pos.y < 0 || pos.y > height))
            throw new OutsideMapBoundariesException(pos);
    }
    public void scan(){
        addAction(new ScanAction());
    }
    public void fly(){
        move(heading.getFront());
        //New pos
        addInformations(Action.INFO.X, "" + pos.x);
        addInformations(Action.INFO.Y, "" + pos.y);

        addAction(new FlyAction());
    }
    public void turnRight(){
        move(heading.getFront());
        move(heading.getRight());
        //New pos
        addInformations(Action.INFO.X, "" + pos.x);
        addInformations(Action.INFO.Y, "" + pos.y);

        heading = heading.getRight();
        addAction(new HeadingAction(heading));
    }
    public void turnLeft(){
        move(heading.getFront());
        move(heading.getLeft());
        //New pos
        addInformations(Action.INFO.X, "" + pos.x);
        addInformations(Action.INFO.Y, "" + pos.y);

        heading = heading.getLeft();
        addAction(new HeadingAction(heading));
    }
    public void echoLeft(){
        addInformations(Action.INFO.X, "" + pos.x);
        addInformations(Action.INFO.Y, "" + pos.y);
        addAction(new EchoAction(heading.getLeft()));
    }
    public void echoRight(){
        addAction(new EchoAction(heading.getRight()));
    }
    public void echoFront(){
        addAction(new EchoAction(heading.getFront()));
    }
    //A combien de case est le bord de gauche
    public int getRangeLeft(){
        switch(heading){
            case N:
                return pos.x;
            case E:
                return pos.y;
            case S:
                return width - 1 - pos.x;
            case W:
                return height - 1 - pos.y;
        }
        return 0;
    }

    //A combien de case est le bord de droite
    public int getRangeRight(){
        switch(heading){
            case N:
                return width - 1 - pos.x;
            case E:
                return height - 1 - pos.y;
            case S:
                return pos.x;
            case W:
                return pos.y;
        }
        return 0;
    }

    //A combien de case est le bord de devant
    public int getRangeFront(){
        switch(heading){
            case N:
                return pos.y;
            case E:
                return width - 1 - pos.x;
            case S:
                return height - 1 - pos.y;
            case W:
                return pos.x;
        }
        return 0;
    }

    //A combien de case est le bord de derrière
    public int getRangeRear(){
        switch(heading){
            case N:
                return height - 1 - pos.y;
            case E:
                return pos.x;
            case S:
                return pos.y;
            case W:
                return width - 1 - pos.x;
        }
        return 0;
    }

    public Coords getPosition(){
        return pos;
    }

    public Direction getDirection(){
        return heading;
    }
}
