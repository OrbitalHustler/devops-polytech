package fr.unice.polytech.qgl.qbd.stats;

import fr.unice.polytech.qgl.qbd.gameObject.map.Resource;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class StatTest {

    @Test
    public void testAverageExploitCost() throws Exception {
        HashMap<Resource, Integer> contracts = new HashMap<>();
        contracts.put(Resource.FISH, 100);
        contracts.put(Resource.WOOD, 300);
        Statistics stats = new Statistics(contracts, 100, 80, 50, 50);

        stats.explore(Resource.FISH, ExploreStr.HIGH, ExploreStr.EASY);
        stats.exploit(15,10);

        stats.move(50,51);
        stats.explore(Resource.FISH, ExploreStr.HIGH, ExploreStr.EASY);
        stats.exploit(20,5);

        assertEquals(7.5, stats.getAverageExploitCostforNameAndConditions(Resource.FISH, ExploreStr.HIGH, ExploreStr.EASY), 0);
        assertEquals(-1, stats.getAverageExploitCostforNameAndConditions(Resource.FISH, ExploreStr.HIGH, ExploreStr.FAIR), 0);
        assertEquals(-1, stats.getAverageExploitCostforNameAndConditions(Resource.WOOD, ExploreStr.HIGH, ExploreStr.EASY), 0);
        assertEquals(-1, stats.getAverageExploitCostforNameAndConditions(Resource.WOOD, ExploreStr.MEDIUM, ExploreStr.EASY), 0);

        stats.move(50,52);
        stats.explore(Resource.WOOD, ExploreStr.LOW, ExploreStr.HARSH);
        stats.exploit(30,10);
        assertEquals(-1, stats.getAverageExploitCostforNameAndConditions(Resource.WOOD, ExploreStr.MEDIUM, ExploreStr.EASY), 0);
        assertEquals(10, stats.getAverageExploitCostforNameAndConditions(Resource.WOOD, ExploreStr.LOW, ExploreStr.HARSH), 0);
    }
}
