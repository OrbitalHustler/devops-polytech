package fr.unice.polytech.qgl.qbd.gameObject.map;

public enum Resource {
    FISH        (null, null, 0),
    FLOWER      (null, null, 0),
    FRUITS      (null, null, 0),
    FUR         (null, null, 0),
    ORE         (null, null, 0),
    QUARTZ      (null, null, 0),
    SUGAR_CANE  (null, null, 0),
    WOOD        (null, null, 0),
    GLASS       (new Resource[] {QUARTZ, WOOD}, new int[] {5, 10}, 1),
    INGOT       (new Resource[] {ORE, WOOD}, new int[] {5, 5}, 1),
    LEATHER     (new Resource[] {FUR}, new int[] {3}, 1),
    PLANK       (new Resource[] {WOOD}, new int[] {1}, 4),
    RUM         (new Resource[] {SUGAR_CANE, FRUITS}, new int[] {10, 1}, 1);

    private Resource[] ingredients;
    private int[] ingredientsQuantity;
    private int manufacturedQuantity;
    Resource(Resource[] ingredients, int[] ingredientsQuantity, int manufacturedQuantity){
        this.ingredients = ingredients;
        this.ingredientsQuantity = ingredientsQuantity;
        this.manufacturedQuantity = manufacturedQuantity;
    }
}
