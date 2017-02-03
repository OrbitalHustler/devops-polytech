package fr.unice.polytech.qgl.qbd.results;

import fr.unice.polytech.qgl.qbd.actions.ScanAction;
import fr.unice.polytech.qgl.qbd.gameObject.map.Biome;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ScanResult extends Result {
    private ScanAction action;
    private ArrayList<Biome> biomes;
    private ArrayList<String> creeks;

    public ScanResult(ScanAction action, String JSONResult){
        super(JSONResult);
        this.action = action;
    }

    @Override
    public ScanAction getAction() {
        return action;
    }

    @Override
    protected void setExtras(JSONObject extras) {
        biomes = new ArrayList<>();
        creeks = new ArrayList<>();
        System.out.println(extras.toString());
        JSONArray tab = extras.getJSONArray("biomes");
        for (int i = 0; i < tab.length(); ++i)
            biomes.add(Biome.valueOf(tab.getString(i)));
        tab = extras.getJSONArray("creeks");
        for (int i = 0; i < tab.length(); ++i)
            creeks.add(tab.getString(i));
    }

    public ArrayList<Biome> getBiomes(){
        return new ArrayList<>(biomes);
    }

    public ArrayList<String> getCreeks(){
        return new ArrayList<>(creeks);
    }

    public boolean foundCreeks(){
        return !biomes.isEmpty();
    }
}
