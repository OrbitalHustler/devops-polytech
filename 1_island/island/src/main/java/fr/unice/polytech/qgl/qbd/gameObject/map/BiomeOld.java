package fr.unice.polytech.qgl.qbd.gameObject.map;

import java.util.HashMap;

public class BiomeOld {
    private static final HashMap<String, BiomeOld> biomes;

    @Override
    public String toString() {
        return "Biome{" +
                "resourcesProbability=" + resourcesProbability +
                ", name='" + name + '\'' +
                ", crossFactor=" + crossFactor +
                '}';
    }

    public static BiomeOld getBiome(String s){
        return biomes.get(s);
    }
    private final HashMap<String, Double> resourcesProbability;
    private final String name;
    private final double crossFactor;

    public BiomeOld(String name, HashMap<String, Double> resourcesProbability, double crossFactor) {
        this.name = name;
        this.resourcesProbability = resourcesProbability;
        this.crossFactor = crossFactor;
    }

    public HashMap<String, Double> getResourcesProbability() {
        return resourcesProbability;
    }

    public String getName() {
        return name;
    }

    public double getCrossFactor() {
        return crossFactor;
    }

    static {
        biomes = new HashMap<>();
        HashMap<String, Double> production;
        String name;

        double crossFactor;
        //ALPINE
        name = "ALPINE";
        crossFactor = 2.5;
        production = new HashMap<>();
        production.put("ORE", 0.2);
        production.put("FLOWER", 0.05);
        biomes.put(name, new BiomeOld(name, production, crossFactor));

        /************************************
         * Wet biomes: mangroves and snow  **
         ************************************/

        name = "MANGROVE";
        production = new HashMap<>();
        production.put("WOOD", 0.6);
        production.put("FLOWER", 0.4);
        crossFactor = 1.8;
        biomes.put(name, new BiomeOld(name, production, crossFactor));

        name = "SNOW";
        production = new HashMap<>();
        crossFactor = 1.2;
        biomes.put(name, new BiomeOld(name, production, crossFactor));

        /*******************
         * Forest biomes  **
         *******************/

        name = "TROPICAL_RAIN_FOREST";
        production = new HashMap<>();
        production.put("WOOD", 0.4);
        production.put("SUGAR_CANE", 0.4);
        production.put("FRUITS", 0.2);
        crossFactor = 1.8;
        biomes.put(name, new BiomeOld(name, production, crossFactor));

        name = "TROPICAL_SEASONAL_FOREST";
        production = new HashMap<>();
        production.put("WOOD", 0.4);
        production.put("SUGAR_CANE", 0.5);
        production.put("FRUITS", 0.1);
        crossFactor = 1.4;
        biomes.put(name, new BiomeOld(name, production, crossFactor));

        name = "TAIGA";
        production = new HashMap<>();
        production.put("WOOD", 1.0);
        crossFactor = 1.3;
        biomes.put(name, new BiomeOld(name, production, crossFactor));

        name = "TEMPERATE_RAIN_FOREST";
        production = new HashMap<>();
        production.put("WOOD", 0.8);
        production.put("FUR", 0.2);
        crossFactor = 1.2;
        biomes.put(name, new BiomeOld(name, production, crossFactor));

        name = "TEMPERATE_DECIDUOUS_FOREST";
        production = new HashMap<>();
        production.put("WOOD", 1.0);
        crossFactor = 1.2;
        biomes.put(name, new BiomeOld(name, production, crossFactor));

        /*****************************************************
         * "Prairie" biomes: grassland, shrubland and tundra *
         *****************************************************/

        name = "GRASSLAND";
        production = new HashMap<>();
        production.put("FUR", 1.0);
        crossFactor = 0.8;
        biomes.put(name, new BiomeOld(name, production, crossFactor));

        name = "SHRUBLAND";
        production = new HashMap<>();
        production.put("FUR", 1.0);
        crossFactor = 0.8;
        biomes.put(name, new BiomeOld(name, production, crossFactor));

        name = "TUNDRA";
        production = new HashMap<>();
        production.put("FUR", 1.0);
        crossFactor = 0.9;
        biomes.put(name, new BiomeOld(name, production, crossFactor));

        /***********************************************
         * Dry biomes: beach, deserts and alpine rocks *
         ***********************************************/

        name = "ALPINE";
        production = new HashMap<>();
        production.put("ORE", 0.2);
        production.put("FLOWER", 0.05);
        crossFactor = 2.5;
        biomes.put(name, new BiomeOld(name, production, crossFactor));

        name = "BEACH";
        production = new HashMap<>();
        production.put("QUARTZ", 0.2);
        crossFactor = 0.9;
        biomes.put(name, new BiomeOld(name, production, crossFactor));

        name = "SUB_TROPICAL_DESERT";
        production = new HashMap<>();
        production.put("ORE", 0.2);
        production.put("QUARTZ", 0.4);
        crossFactor = 1.1;
        biomes.put(name, new BiomeOld(name, production, crossFactor));

        name = "TEMPERATE_DESERT";
        production = new HashMap<>();
        production.put("ORE", 0.3);
        production.put("QUARTZ", 0.3);
        crossFactor = 1.1;
        biomes.put(name, new BiomeOld(name, production, crossFactor));

        /****************
         * Water faces **
         ****************/

        name = "OCEAN";
        production = new HashMap<>();
        production.put("FISH", 0.9);
        crossFactor = 3.0;
        biomes.put(name, new BiomeOld(name, production, crossFactor));

        name = "LAKE";
        production = new HashMap<>();
        production.put("FISH", 0.8);
        crossFactor = 2.0;
        biomes.put(name, new BiomeOld(name, production, crossFactor));

        name = "GLACIER";
        production = new HashMap<>();
        production.put("FLOWER", 0.05);
        crossFactor = 2.5;
        biomes.put(name, new BiomeOld(name, production, crossFactor));

    }


}
