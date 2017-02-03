package fr.unice.polytech.qgl.qbd.actions;

import fr.unice.polytech.qgl.qbd.results.Result;
import org.json.JSONObject;

import java.util.HashMap;

public abstract class Action {
    public enum INFO {
        X, Y, MISC
    }
    public enum NAME {
        ECHO("echo"), FLY("fly"), HEADING("heading"), SCAN("scan"), STOP("stop");

        private String JSONString;

        NAME(String JSONString){
            this.JSONString = JSONString;
        }

        public String toJSONString(){
            return this.JSONString;
        }
    }
    private NAME name;
    private HashMap<String, String> parameters;
    private HashMap<INFO, String> informations;

    public Action(NAME name){
        this.name = name;
        parameters = new HashMap<>();
        informations = new HashMap<>();
    }

    public void addInformation(INFO key, String value){
        informations.put(key, value);
    }
    public String getInformation(INFO key){
        return informations.get(key);
    }
    public Action(NAME name, String... arguments) {
        this(name);
        String key = "";
        for (int i = 0; i < arguments.length; i++) {
            if (key.isEmpty()) {
                key = arguments[i];
            } else {
                this.addParameter(key, arguments[i]);
                key = "";
            }
        }
    }

    protected void addParameter(String name, String value){
        parameters.put(name, value);
    }

    public NAME getName() {
        return name;
    }

    public String toJSONString(){
        JSONObject obj = new JSONObject();
        obj.put("action", name.toJSONString());
        JSONObject p = new JSONObject();
        for (String s : parameters.keySet())
            p.put(s, parameters.get(s));
        obj.put("parameters", p);
        return obj.toString();
    }

    public abstract Result createResult(String JSONResult);
    @Override
    public String toString() {
        return toJSONString();
    }

}
