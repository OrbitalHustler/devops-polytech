package fr.unice.polytech.qgl.qbd.gameObject.map;

import java.util.HashMap;


public class ResourceOld {
    private int count;
    private int craftedCount;
    private HashMap<String, Integer> recipe;

    public ResourceOld(){
        count = 0;
        craftedCount = 1;
        recipe = new HashMap<>();
    }
    public void addIngredient(String s, Integer i){
        recipe.put(s, i);
    }
    public void setCraftedCount(int c){
        craftedCount = c;
    }
    /*public boolean isPrimary(){
        return recipe.isEmpty();
    }
    public int getCount() {
        return count;
    }
    public int getCraftedCount() {
        return craftedCount;
    }*/
    public HashMap<String, Integer> getRecipe(){
        return new HashMap<String, Integer>(recipe);
    }
}
