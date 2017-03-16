package fr.unice.polytech.qgl.qbd.gameObject.map;

import java.util.HashMap;

public class Cell {
    private boolean isGround;
    private HashMap<BiomeOld,Float> biomes;
    public Cell(){
        biomes = new HashMap<>();
    }
    public Cell(Cell c){
        biomes = new HashMap<BiomeOld, Float>(c.biomes);
    }
    public HashMap<BiomeOld, Float> getBiomes() {
        return new HashMap<>(biomes);
    }
    public boolean isGround(){
        return isGround;
    }
    public void setGround(boolean ground){
        isGround = ground;
    }
}
