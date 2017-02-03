package fr.unice.polytech.qgl.qbd.results;

import fr.unice.polytech.qgl.qbd.actions.Action;
import org.json.JSONObject;

public abstract class Result {
    private int cost;
    private boolean status;

    public Result(String JSONResult){
        setResult(JSONResult);
    }
    public abstract Action getAction();
    private void setResult(String JSONString){
        JSONObject resultObject = new JSONObject(JSONString);
        cost = resultObject.getInt("cost");
        status = resultObject.getString("status").equals("OK");
        if (resultObject.has("extras"))
            setExtras(resultObject.getJSONObject("extras"));
    }
    protected void setExtras(JSONObject extras){}
    public int getCost(){
        return cost;
    }
    public boolean getStatus(){
        return status;
    }
}
