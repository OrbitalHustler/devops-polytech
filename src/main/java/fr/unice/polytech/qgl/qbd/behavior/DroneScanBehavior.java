package fr.unice.polytech.qgl.qbd.behavior;

import fr.unice.polytech.qgl.qbd.GameState;
import fr.unice.polytech.qgl.qbd.actions.Action;
import fr.unice.polytech.qgl.qbd.driver.DroneDriver;
import fr.unice.polytech.qgl.qbd.results.Result;

import java.util.LinkedList;

public class DroneScanBehavior extends Behavior {
    private DroneDriver driver;

    public DroneScanBehavior(GameState game, DroneDriver driver) {
        super(game);
        this.driver = driver;
    }

    /*
     * Zigzaguer au dessus de l'ile en scanant les côtes et quelques cases
     * à l'interieur pour déterminer la disposition des biomes
     */
    @Override
    public void makeAction() {

    }

    @Override
    public Behavior acknowledgeResults(Result result) {
        return this;
    }
}
