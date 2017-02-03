package fr.unice.polytech.qgl.qbd.gameObject.map;
import static fr.unice.polytech.qgl.qbd.gameObject.map.Resource.*;
public enum Biome {

    OCEAN(new Resource[] {FISH},
            new double [] {0.9}, 3),
    LAKE(new Resource[] {FISH},
            new double [] {0.8}, 2),
    BEACH(new Resource[] {QUARTZ},
            new double [] {0.2}, 0.9),
    GRASSLAND(new Resource[] {FUR},
            new double [] {1}, 0.8),
    MANGROVE(new Resource[] {WOOD, FLOWER},
            new double [] {0.6, 0.4}, 1.8),
    TROPICAL_RAIN_FOREST(new Resource[] {WOOD, SUGAR_CANE, FRUITS},
            new double [] {0.4, 0.4, 0.2}, 1.8),
    TROPICAL_SEASONAL_FOREST(new Resource[] {WOOD, SUGAR_CANE, FRUITS},
            new double [] {0.4, 0.5, 0.1}, 1.4),
    TEMPERATE_DECIDUOUS_FOREST(new Resource[] {WOOD},
            new double [] {1}, 1.2),
    TEMPERATE_RAIN_FOREST(new Resource[] {WOOD, FUR},
            new double [] {0.8, 0.2}, 1.2),
    TEMPERATE_DESERT(new Resource[] {ORE, QUARTZ},
            new double [] {0.3, 0.3}, 1.1),
    TAIGA(new Resource[] {WOOD},
            new double [] {1}, 1.3),
    SNOW(new Resource[] {},
            new double [] {}, 1.2),
    TUNDRA(new Resource[] {FUR},
            new double [] {1}, 0.8),
    //Probabilité sensée etre a 1 total, corriger?
    ALPINE(new Resource[] {ORE, FLOWER},
            new double [] {0.2, 0.05}, 2.5),
    GLACIER(new Resource[] {FLOWER},
            new double [] {0.05}, 2.5),
    SHRUBLAND(new Resource[] {FUR},
            new double [] {1}, 0.8),
    SUB_TROPICAL_DESERT(new Resource[] {ORE, QUARTZ},
            new double [] {0.2, 0.4}, 1.1);

    private Resource[] resources;
    private double[] resourcesProbability;
    private double crossFactor;
    Biome(Resource[] resources, double[] resourcesProbability, double crossFactor){
        this.resources = resources;
        this.resourcesProbability = resourcesProbability;
        this.crossFactor = crossFactor;
    }

    public Resource[] getResources(){
        return resources.clone();
    }
    public double getProbability(Resource r){
        int index = 0;
        boolean found = false;
        while (index < resources.length){
            if (resources[index] == r){
                found = true;
                break;
            }
            ++index;
        }
        if (found)
            return resourcesProbability[index];
        return 0;
    }
}
