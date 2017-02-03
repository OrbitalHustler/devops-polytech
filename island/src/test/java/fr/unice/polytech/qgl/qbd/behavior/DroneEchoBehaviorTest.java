package fr.unice.polytech.qgl.qbd.behavior;

import fr.unice.polytech.qgl.qbd.GameState;
import fr.unice.polytech.qgl.qbd.actions.Action;
import fr.unice.polytech.qgl.qbd.actions.EchoAction;
import fr.unice.polytech.qgl.qbd.actions.HeadingAction;
import fr.unice.polytech.qgl.qbd.driver.DroneDriver;
import fr.unice.polytech.qgl.qbd.gameObject.Direction;
import fr.unice.polytech.qgl.qbd.gameObject.map.Coords;
import fr.unice.polytech.qgl.qbd.gameObject.map.DroneMap;
import fr.unice.polytech.qgl.qbd.utils.ResultGenerator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

public class DroneEchoBehaviorTest {

    private LinkedList<Action> actionList;
    private GameState game;
    private DroneEchoBehavior behavior;
    private DroneDriver driver;

    private void setup(int width, int height, Coords pos, Direction heading){
        game = new GameState(5, 10000, null);
        game.setMap(new DroneMap(width, height));
        actionList = new LinkedList<>();
        driver = new DroneDriver(actionList, heading, pos, width, height);
        behavior = new DroneEchoBehavior(game, driver);
    }
    @Test
    public void testAll() throws Exception {
        setup(10, 10, new Coords(2, 0), Direction.E);
        Action a;
        ResultGenerator gen = new ResultGenerator();
        EchoAction echo;
        HeadingAction heading;

        //(echo, fly) initial direction sud
        a = actionList.poll();
        assertEquals(Action.NAME.ECHO, a.getName());
        echo = (EchoAction) a;
        assertEquals(Direction.S, echo.getDirection());
        gen.addExtras("range", 3); gen.addExtras("found", "GROUND");
        behavior.acknowledgeResults(gen.generateResult(a));
        
        a = actionList.poll();
        assertEquals(Action.NAME.FLY, a.getName());
        behavior.acknowledgeResults(gen.generateResult(a));
        
        //(echo, fly) * 5 direction sud
        for (int i = 0; i < 5; ++i){
            behavior.makeAction();

            //Echo
            a = actionList.poll();
            assertEquals(Action.NAME.ECHO, a.getName());
            echo = (EchoAction) a;
            assertEquals(Direction.S, echo.getDirection());
            gen.addExtras("range", 3); gen.addExtras("found", "GROUND");
            behavior.acknowledgeResults(gen.generateResult(a));

            //Fly
            a = actionList.poll();
            assertEquals(Action.NAME.FLY, a.getName());
            behavior.acknowledgeResults(gen.generateResult(a));
        }

        //heading direction sud
        behavior.makeAction();

        a = actionList.poll();
        assertEquals(Action.NAME.ECHO, a.getName());
        echo = (EchoAction) a;
        assertEquals(Direction.S, echo.getDirection());
        gen.addExtras("range", 3);gen.addExtras("found", "GROUND");

        behavior.acknowledgeResults(gen.generateResult(a));
        a = actionList.poll();
        assertEquals(Action.NAME.HEADING, a.getName());
        heading = (HeadingAction) a;
        assertEquals(Direction.S, heading.getDirection());
        behavior.acknowledgeResults(gen.generateResult(a));

        //(echo, fly) * 7 direction ouest
        for (int i = 0; i < 7; ++i){
            behavior.makeAction();

            a = actionList.poll();
            assertEquals(Action.NAME.ECHO, a.getName());
            echo = (EchoAction) a;
            assertEquals(Direction.W, echo.getDirection());
            gen.addExtras("range", 3); gen.addExtras("found", "GROUND");
            behavior.acknowledgeResults(gen.generateResult(a));

            a = actionList.poll();
            assertEquals(Action.NAME.FLY, a.getName());
            behavior.acknowledgeResults(gen.generateResult(a));
        }
        //heading direction ouest
        behavior.makeAction();

        a = actionList.poll();
        assertEquals(Action.NAME.ECHO, a.getName());
        echo = (EchoAction) a;
        assertEquals(Direction.W, echo.getDirection());
        gen.addExtras("range", 3); gen.addExtras("found", "GROUND");
        behavior.acknowledgeResults(gen.generateResult(a));

        a = actionList.poll();
        assertEquals(Action.NAME.HEADING, a.getName());
        heading = (HeadingAction) a;
        assertEquals(Direction.W, heading.getDirection());
        behavior.acknowledgeResults(gen.generateResult(a));

        //(echo, fly) * 7 direction nord
        for (int i = 0; i < 7; ++i){
            behavior.makeAction();

            a = actionList.poll();
            assertEquals(Action.NAME.ECHO, a.getName());
            echo = (EchoAction) a;
            assertEquals(Direction.N, echo.getDirection());
            gen.addExtras("range", 3); gen.addExtras("found", "GROUND");
            behavior.acknowledgeResults(gen.generateResult(a));

            a = actionList.poll();
            assertEquals(Action.NAME.FLY, a.getName());
            behavior.acknowledgeResults(gen.generateResult(a));
        }
        //heading direction nord
        behavior.makeAction();

        a = actionList.poll();
        assertEquals(Action.NAME.ECHO, a.getName());
        echo = (EchoAction) a;
        assertEquals(Direction.N, echo.getDirection());
        gen.addExtras("range", 3); gen.addExtras("found", "GROUND");
        behavior.acknowledgeResults(gen.generateResult(a));

        a = actionList.poll();
        assertEquals(Action.NAME.HEADING, a.getName());
        heading = (HeadingAction) a;
        assertEquals(Direction.N, heading.getDirection());
        behavior.acknowledgeResults(gen.generateResult(a));

        //(echo, fly) * 7 direction est
        for (int i = 0; i < 7; ++i){
            behavior.makeAction();

            a = actionList.poll();
            assertEquals(Action.NAME.ECHO, a.getName());
            echo = (EchoAction) a;
            assertEquals(Direction.E, echo.getDirection());
            gen.addExtras("range", 3); gen.addExtras("found", "GROUND");
            behavior.acknowledgeResults(gen.generateResult(a));

            a = actionList.poll();
            assertEquals(Action.NAME.FLY, a.getName());
            behavior.acknowledgeResults(gen.generateResult(a));
        }
        //heading direction est
        behavior.makeAction();

        a = actionList.poll();
        assertEquals(Action.NAME.ECHO, a.getName());
        echo = (EchoAction) a;
        assertEquals(Direction.E, echo.getDirection());
        gen.addExtras("range", 3); gen.addExtras("found", "GROUND");
        behavior.acknowledgeResults(gen.generateResult(a));

        a = actionList.poll();
        assertEquals(Action.NAME.HEADING, a.getName());
        heading = (HeadingAction) a;
        assertEquals(Direction.E, heading.getDirection());
        behavior.acknowledgeResults(gen.generateResult(a));

        //last echo and fly
        behavior.makeAction();

        a = actionList.poll();
        assertEquals(Action.NAME.ECHO, a.getName());
        echo = (EchoAction) a;
        assertEquals(Direction.S, echo.getDirection());
        gen.addExtras("range", 3); gen.addExtras("found", "GROUND");
        behavior.acknowledgeResults(gen.generateResult(a));

        a = actionList.poll();
        assertEquals(Action.NAME.FLY, a.getName());
        //Changement de behavior vers un DroneScanBehavior
        Behavior returnedBehavior =
                behavior.acknowledgeResults(gen.generateResult(a));
        assertEquals(DroneScanBehavior.class, returnedBehavior.getClass());
    }
}