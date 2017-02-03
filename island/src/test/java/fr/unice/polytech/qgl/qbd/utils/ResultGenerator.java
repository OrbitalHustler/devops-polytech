package fr.unice.polytech.qgl.qbd.utils;

import fr.unice.polytech.qgl.qbd.actions.Action;
import fr.unice.polytech.qgl.qbd.results.Result;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

@Ignore
public class ResultGenerator {
    private int cost;
    private boolean status;
    private HashMap<String, String> extrasString;
    private HashMap<String, Integer> extrasInt;
    private HashMap<String, String[]> extrasArray;
    public ResultGenerator(){
        cost = 1;
        status = true;
        extrasString = new HashMap<>();
        extrasInt = new HashMap<>();
        extrasArray = new HashMap<>();
    }
    public void addExtras(String key, int value){
        extrasInt.put(key, value);
    }
    public void addExtras(String key, String value){
        extrasString.put(key, value);
    }
    public void addExtras(String key, String[] value){
        extrasArray.put(key, value);
    }
    public Result generateResult(Action a){
        return a.createResult(generateJSONString());
    }
    public String generateJSONString(){
        JSONObject json = new JSONObject();
        json.put("cost", cost);
        JSONObject extras = new JSONObject();
        for (String s : this.extrasString.keySet())
            extras.put(s, this.extrasString.get(s));
        for (String s : this.extrasInt.keySet())
            extras.put(s, this.extrasInt.get(s));
        for (String s : this.extrasArray.keySet()){
            JSONArray tab = new JSONArray();
            for (String s2 : extrasArray.get(s))
                tab.put(s2);
            extras.put(s, tab);
        }

        if (extras.length() > 0)
            json.put("extras", extras);
        json.put("status", status ? "OK" : "non");

        extrasString = new HashMap<>();
        extrasInt = new HashMap<>();
        extrasArray = new HashMap<>();

        return json.toString();
    }

}
