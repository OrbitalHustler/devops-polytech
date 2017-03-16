package fr.unice.polytech.qgl.qbd.gameObject;

import fr.unice.polytech.qgl.qbd.Utils;
import fr.unice.polytech.qgl.qbd.gameObject.map.ResourceOld;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.HashMap;

public class Inventory {
    private HashMap<String, ResourceOld> resources;

    public Inventory(){
        resources = new HashMap<>();
        initializeResources();
    }
    public ResourceOld getResource(String name){
        return resources.get(name);
    }

    private void initializeResources(){
        InputStream is = this.getClass().getResourceAsStream("resources.json");
        String jsonTxt = Utils.convertStreamToString(is);
        JSONObject resParser = new JSONObject(jsonTxt);
        JSONArray primary = resParser.getJSONArray("primary");
        for (int i = 0; i < primary.length(); ++i){
            resources.put((String) primary.get(i), new ResourceOld());
        }
        JSONObject manufactured = resParser.getJSONObject("manufactured");
        for (String s : JSONObject.getNames(manufactured)){
            JSONObject resourceObject = manufactured.getJSONObject(s);
            ResourceOld resource = new ResourceOld();
            resource.setCraftedCount(resourceObject.getInt("QTY"));
            JSONObject ingredients = resourceObject.getJSONObject("ingredients");
            for (String s2 : JSONObject.getNames(ingredients))
                resource.addIngredient(s2, ingredients.getInt(s2));
            resources.put(s, resource);
        }
    }
}
