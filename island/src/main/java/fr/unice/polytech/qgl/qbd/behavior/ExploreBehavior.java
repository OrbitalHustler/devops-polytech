package fr.unice.polytech.qgl.qbd.behavior;

import fr.unice.polytech.qgl.qbd.GameState;
import fr.unice.polytech.qgl.qbd.results.Result;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * PolyTech Nice / SI3 / Module POO-Java
 * Annee 2015 - qbd - Lab 3
 * Package fr.unice.polytech.qgl.qbd.behavior
 *
 * @author Flavian Jacquot
 * @version 01/12/2015
 * @since 1.8.0_60
 *
 * Résumé : land.
 *
 * Prérequis :
 * une crique
 *
 * Nombre de tours utilisés :
 * 1
 *
 * Résultat :
 * Passe de la phase aérienne à la phase terrestre.
 */

public class ExploreBehavior extends Behavior {
    private static Logger logger= LogManager.getLogger(ExploreBehavior.class);

    public ExploreBehavior(GameState game) {
        super(game);
    }

    @Override
    public  void makeAction() {

    }

    @Override
    public Behavior acknowledgeResults(Result result) {
        return this;
    }
}
