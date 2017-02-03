package fr.unice.polytech.qgl.qbd.actions;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class ActionGenerator {
    private LinkedList<Action> actionList;
    private HashMap<Action.INFO, String> informations;

    public ActionGenerator(LinkedList<Action> actionList){
        this.actionList = actionList;
        informations = new HashMap<>();
    }
    public ActionGenerator(ActionGenerator ag){
        this(ag.actionList);
    }
    public void addInformations(Action.INFO key, String value){
        informations.put(key, value);
    }
    protected void addAction(Action action){
        if (!informations.isEmpty()) {
            for (Action.INFO i : informations.keySet())
                action.addInformation(i, informations.get(i));
            informations = new HashMap<>();
        }
        actionList.add(action);
    }
}
