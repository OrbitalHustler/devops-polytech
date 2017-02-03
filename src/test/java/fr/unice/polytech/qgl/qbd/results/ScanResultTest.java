package fr.unice.polytech.qgl.qbd.results;

import fr.unice.polytech.qgl.qbd.actions.ScanAction;
import fr.unice.polytech.qgl.qbd.gameObject.map.Biome;
import fr.unice.polytech.qgl.qbd.utils.ResultGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScanResultTest {

    ScanResult r;

    @Before
    public void setup(){
        ScanAction a = new ScanAction();
        ResultGenerator gen = new ResultGenerator();
        gen.addExtras("biomes", new String[] {"GLACIER", "ALPINE"});
        gen.addExtras("creeks", new String[] {"creek1", "creek2"});
        r = new ScanResult(a, gen.generateJSONString());
    }

    @Test
    public void testGetBiomes() throws Exception {
        assertEquals(2, r.getBiomes().size());
        assertEquals(Biome.GLACIER, r.getBiomes().get(0));
        assertEquals(Biome.ALPINE, r.getBiomes().get(1));
    }

    @Test
    public void testGetCreeks() throws Exception {
        assertEquals(2, r.getCreeks().size());
        assertEquals("creek1", r.getCreeks().get(0));
        assertEquals("creek2", r.getCreeks().get(1));
    }

    @Test
    public void testFoundCreeks() throws Exception {
        assertEquals(true, r.foundCreeks());
    }
}