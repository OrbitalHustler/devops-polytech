package fr.unice.polytech.qgl.qbd;

import eu.ace_design.island.bot.IExplorerRaid;
import fr.unice.polytech.qgl.qbd.actions.Action;
import fr.unice.polytech.qgl.qbd.actions.StopAction;
import fr.unice.polytech.qgl.qbd.behavior.Behavior;
import fr.unice.polytech.qgl.qbd.behavior.DroneInitialBehavior;
import fr.unice.polytech.qgl.qbd.driver.DroneDriver;
import fr.unice.polytech.qgl.qbd.gameObject.Direction;
import fr.unice.polytech.qgl.qbd.results.Result;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedList;

public class Explorer implements IExplorerRaid {
    private static Logger logger= LogManager.getLogger(Explorer.class);

    private LinkedList<Action> listActions;
    private Action lastAction;
    private Behavior behavior;
    private GameState game;
    private Stats stats;

    public Explorer(){
        listActions = new LinkedList<>();
        stats = new Stats();
        /*logger.trace("trace enabled");
        logger.debug("debug enabled");
        logger.info("info enabled");
        logger.warn("warn enabled");
        logger.error("error enabled");
        logger.fatal("fatal enabled");*/
    }

    public void initialize(String context) {
        //@TODO: DELETE
        int a = 2*3 / 5;
        if (true && true || true){

        }


        System.out.println(1 - 2);
        JSONObject resParser = new JSONObject(context);
        Direction heading = Direction.get(resParser.getString("heading"));

        HashMap<String, Integer> contracts = new HashMap<>();
        JSONArray contractsJson = resParser.getJSONArray("contracts");
        for (int i = 0; i < contractsJson.length(); i++) {
            JSONObject oneContract = contractsJson.getJSONObject(i);
            String resource = oneContract.getString("resource");
            int amount = oneContract.getInt("amount");
            contracts.put(resource, amount);
        }

        game = new GameState(
            resParser.getInt("men"),
            resParser.getInt("budget"),
            contracts
        );
        behavior = new DroneInitialBehavior(game, new DroneDriver(listActions, heading), heading);
    }

    public String takeDecision() {
        try{
            if (listActions.isEmpty())
                behavior.makeAction();
            lastAction = listActions.poll();
            return lastAction.toJSONString();
        }catch (Exception e){
            return new StopAction().toJSONString();
        }
    }

    //C'est la qu'on change le behavior si besoin est
    public void acknowledgeResults(String results) {
        Result r = lastAction.createResult(results);
        behavior = behavior.acknowledgeResults(r);
        if (game.getMap() != null)
            game.getMap().acknowledgeResults(r);
    }
}
