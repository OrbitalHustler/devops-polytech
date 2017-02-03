package fr.unice.polytech.qgl.qbd.results;

import fr.unice.polytech.qgl.qbd.actions.EchoAction;
import org.json.JSONObject;

public class EchoResult extends Result{
    private EchoAction action;
    private int range;
    private boolean groundFound;

    public EchoResult(EchoAction action, String JSONResult){
        super(JSONResult);
        this.action = action;
    }
    @Override
    public EchoAction getAction(){
        return action;
    }
    @Override
    protected void setExtras(JSONObject extras) {
        groundFound = extras.getString("found").equals("GROUND");
        range = extras.getInt("range");
    }
    public boolean getGroundFound(){
        return groundFound;
    }

    public int getRange(){
        return range;
    }
}
