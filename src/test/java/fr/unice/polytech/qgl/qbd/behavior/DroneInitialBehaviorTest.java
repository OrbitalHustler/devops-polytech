package fr.unice.polytech.qgl.qbd.behavior;

import fr.unice.polytech.qgl.qbd.GameState;
import fr.unice.polytech.qgl.qbd.actions.Action;
import fr.unice.polytech.qgl.qbd.driver.DroneDriver;
import fr.unice.polytech.qgl.qbd.gameObject.Direction;
import org.junit.Test;

import java.util.LinkedList;

/**
 * PolyTech Nice / SI3 / Module POO-Java
 * Annee 2015 - qbd - Lab 3
 * Package fr.unice.polytech.qgl.qbd.behavior
 *
 * @author Flavian Jacquot
 * @version 02/01/2016
 * @since 1.8.0_60
 */
public class DroneInitialBehaviorTest {

    private LinkedList<Action> actionList;
    private GameState game;
    private DroneInitialBehavior behavior;

    private void setup(Direction heading){
        game = new GameState(5, 10000, null);
        actionList = new LinkedList<>();
        behavior = new DroneInitialBehavior(game, new DroneDriver(
                actionList, heading
        ), heading);
    }

    /*
     * Teste le comportement sur une carte 10*10 en apparaissant sur le bord Sud
     * à la case x = 3
     */
    @Test
    public void spawnCorner(){
        /*setup(Direction.N);
        //Vérif premiers écho gauche et droite
        Action a = actionList.poll();
        assertEquals(Actions.ECHO, a.getName());
        assertEquals("W", a.getParameter("direction"));
        behavior.acknowledgeResults(new Result("{ \"cost\": 1, \"extras\": { \"range\": 3, " +
                "\"found\": \"OUT_OF_RANGE\" }, \"status\": \"OK\" }", a));
        a = actionList.poll();
        assertEquals(Actions.ECHO, a.getName());
        assertEquals("E", a.getParameter("direction"));
        behavior.acknowledgeResults(new Result("{ \"cost\": 1, \"extras\": { \"range\": 6, " +
                "\"found\": \"OUT_OF_RANGE\" }, \"status\": \"OK\" }", a));

        //Vérif des étapes de déplacement pour coller le bord Ouest
        behavior.makeAction();
        a = actionList.poll();
        assertEquals(Actions.HEADING, a.getName());
        assertEquals("W", a.getParameter("direction"));
        behavior.acknowledgeResults(new Result("{ \"cost\": 4, \"extras\": {}, \"status\": \"OK\" }", a));
    }
    @Test
    public void testAll() {
        setup(Direction.N);

        //Vérif premiers écho gauche et droite
        Action a = actionList.poll();
        assertEquals(Actions.ECHO, a.getName());
        assertEquals("W", a.getParameter("direction"));
        behavior.acknowledgeResults(new Result("{ \"cost\": 1, \"extras\": { \"range\": 3, " +
                "\"found\": \"OUT_OF_RANGE\" }, \"status\": \"OK\" }", a));
        a = actionList.poll();
        assertEquals(Actions.ECHO, a.getName());
        assertEquals("E", a.getParameter("direction"));
        behavior.acknowledgeResults(new Result("{ \"cost\": 1, \"extras\": { \"range\": 6, " +
                "\"found\": \"OUT_OF_RANGE\" }, \"status\": \"OK\" }", a));

        //Vérif des étapes de déplacement pour coller le bord Ouest
        behavior.makeAction();
        a = actionList.poll();
        assertEquals(Actions.HEADING, a.getName());
        assertEquals(Direction.W, Direction.valueOf(a.getParameter("direction")));
        behavior.acknowledgeResults(new Result("{ \"cost\": 4, \"extras\": {}, \"status\": \"OK\" }", a));
        a = actionList.poll();
        assertEquals(Actions.FLY, a.getName());
        behavior.acknowledgeResults(new Result("{ \"cost\": 2, \"extras\": {}, \"status\": \"OK\" }", a));
        a = actionList.poll();
        assertEquals(Actions.HEADING, a.getName());
        assertEquals("N", a.getParameter("direction"));
        behavior.acknowledgeResults(new Result("{ \"cost\": 4, \"extras\": {}, \"status\": \"OK\" }", a));
        a = actionList.poll();
        assertEquals(Actions.ECHO, a.getName());
        assertEquals("N", a.getParameter("direction"));
        behavior.acknowledgeResults(new Result("{ \"cost\": 1, \"extras\": { \"range\": 7, " +
                "\"found\": \"OUT_OF_RANGE\" }, \"status\": \"OK\" }", a));

        //Vérifier les dimensions de la carte créée
        assertEquals("map width", 10, game.getMap().getWidth());
        assertEquals("map height", 10, game.getMap().getHeight());*/
    }
}