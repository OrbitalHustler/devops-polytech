package fr.unice.polytech.qgl.qbd.stats;

import fr.unice.polytech.qgl.qbd.gameObject.map.Resource;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ResourceTest {

    @Test
    public void testDefaultConstructor() throws Exception {
        HashMap<Resource, Integer> contracts = new HashMap<>();
        contracts.put(Resource.FISH, 100);
        contracts.put(Resource.WOOD, 300);
        Statistics stats = new Statistics(contracts, 100, 80, 50, 50);
        SampleExplore[][] testMapSize = new SampleExplore[100][80];
        assertEquals(testMapSize, stats.getResourceMap());

        ArrayList<SingularResourceDatabase> globalResourceDatabase = stats.getGlobalResourceDatabase();
        assertEquals(Resource.FISH, stats.getResourceDatabase(Resource.FISH).getName());
    }

    @Test
    public void testCaseSampleAndMove() throws Exception {
        HashMap<Resource, Integer> contracts = new HashMap<>();
        contracts.put(Resource.FISH, 100);
        contracts.put(Resource.WOOD, 300);
        Statistics stats = new Statistics(contracts, 100, 80, 50, 50);
        ArrayList<SingularResourceDatabase> globalResourceDatabase = stats.getGlobalResourceDatabase();
        assertEquals(null, stats.getCurrentCaseSample());
        assertEquals(false, stats.isCurrentCaseExplored());

        stats.move(50,49);
        assertEquals(null, stats.getCurrentCaseSample());
        assertEquals(false, stats.isCurrentCaseExplored());
        stats.explore(Resource.FISH, ExploreStr.HIGH, ExploreStr.EASY);
        assertEquals(true, stats.isCurrentCaseExplored());
        SampleExplore newSample = new SampleExplore(Resource.FISH, ExploreStr.HIGH, ExploreStr.EASY);
        assertEquals(true, newSample.equals(stats.getCurrentCaseSample()));

        stats.move(50,50);
        assertEquals(false, stats.isCurrentCaseExplored());

        stats.move(50,49);
        stats.exploit(10,3);
        SampleExplore newSampleExploit = new SampleExploit(Resource.FISH, ExploreStr.HIGH, ExploreStr.EASY,10,3);
        assertEquals(newSampleExploit, stats.getCurrentCaseSample());
        stats.move(51,49);
        assertEquals(false, stats.isCurrentCaseExplored());
    }
}
