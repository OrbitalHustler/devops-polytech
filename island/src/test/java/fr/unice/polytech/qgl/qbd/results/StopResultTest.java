package fr.unice.polytech.qgl.qbd.results;

import fr.unice.polytech.qgl.qbd.actions.StopAction;
import fr.unice.polytech.qgl.qbd.utils.ResultGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

public class StopResultTest {

    @Test
    public void testGetAction() throws Exception {
        StopAction a = new StopAction();
        ResultGenerator gen = new ResultGenerator();
        StopResult r = new StopResult(a, gen.generateJSONString());
        assertEquals(a, r.getAction());
    }
}