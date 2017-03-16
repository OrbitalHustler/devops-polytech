package fr.unice.polytech.qgl.qbd;

import fr.unice.polytech.qgl.qbd.gameObject.Direction;
import fr.unice.polytech.qgl.qbd.gameObject.Inventory;
import fr.unice.polytech.qgl.qbd.gameObject.map.DroneMap;
import fr.unice.polytech.qgl.qbd.results.Result;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import java.util.*;

public class GameState {
    private static Logger logger= LogManager.getLogger(GameState.class);
    private List<Result> results = new LinkedList<>();
    private DroneMap map;
    private Inventory inventory;
    private HashMap<String, Integer> contracts;
    private int men;
    private int actionPoints;
    public GameState(int men, int actionPoints, HashMap<String, Integer> contracts){
        inventory = new Inventory();
        this.men = men;
        this.actionPoints = actionPoints;
        this.contracts = contracts;
    }

    public void setMap(DroneMap m){
        map = m;
    }

    public List<Result> getResults() {
        return results;
    }

    public void remove(int actionPointsCost)
    {
        this.actionPoints-=actionPointsCost;
    }

    public int getActionPoints() {
        return actionPoints;
    }

    public Direction getHeading(String context) {
        JSONObject resParser = new JSONObject(context);
        return Direction.valueOf(resParser.optString("heading"));
    }

    public int getMen() {
        return men;
    }

    public HashMap<String, Integer> getContracts() {
        return contracts;
    }

    public DroneMap getMap() {
        return map;
    }

    /*public Inventory getInventory() {
        return inventory;
    }*/
}
