package fr.unice.polytech.qgl.qbd.gameObject;

import org.junit.Test;

public class InventoryTest {

    @Test
    public void testGetResource() throws Exception {
        Inventory i = new Inventory();
        i.getResource("RUM").getRecipe().put("Test", 2);

        System.out.println(i.getResource("RUM").getRecipe().get("SUGAR_CANE"));
    }

    @Test
    public void testGetResource1() throws Exception {

    }
}