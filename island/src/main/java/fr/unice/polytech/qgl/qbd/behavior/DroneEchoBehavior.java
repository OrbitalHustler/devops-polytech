package fr.unice.polytech.qgl.qbd.behavior;

import fr.unice.polytech.qgl.qbd.GameState;
import fr.unice.polytech.qgl.qbd.driver.DroneDriver;
import fr.unice.polytech.qgl.qbd.gameObject.map.Coords;
import fr.unice.polytech.qgl.qbd.results.Result;

/*
 * Fait le tour de la map en faisant des echos sur l'île
 */
public class DroneEchoBehavior extends Behavior {
    private DroneDriver driver;
    private boolean turnLeft; //sens des virages à prendre
    private Coords initialPosition;

    //TODO
    public DroneEchoBehavior(GameState game, DroneDriver driver) {
        super(game);
        this.driver = driver;
        //Déterminer dans quel sens tourner
        turnLeft = driver.getRangeRight() < driver.getRangeLeft();
        initialPosition = driver.getPosition();
        if (turnLeft) driver.echoLeft();
        else driver.echoRight();
        driver.fly();
    }

    /*
     * Objectif: faire le tour de l'ile avec des echos pour identifier les contours
     */
    @Override
    public void makeAction() {
        //Faire l'écho du bon côté
        if (turnLeft)
            driver.echoLeft();
        else
            driver.echoRight();

        //Avancer si on est a une case du bord
        int temp = driver.getRangeFront();
        if (driver.getRangeFront() > 1)
            driver.fly();

        //Sinon tourner dans la bonne direction
        else{
            if (turnLeft)
                driver.turnLeft();
            else
                driver.turnRight();
        }
    }

    @Override
    public Behavior acknowledgeResults(Result result) {
        //Si on a fait un tour complet et on est revenu sur la case de départ
        if (driver.getPosition().equals(initialPosition)){
            return new DroneScanBehavior(game, driver);
        }
        return this;
    }
}

