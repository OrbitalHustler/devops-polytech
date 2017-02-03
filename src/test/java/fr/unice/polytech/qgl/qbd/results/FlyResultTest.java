package fr.unice.polytech.qgl.qbd.results;

import fr.unice.polytech.qgl.qbd.actions.FlyAction;
import fr.unice.polytech.qgl.qbd.utils.ResultGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlyResultTest {

    @Test
    public void testGetAction() throws Exception {
        FlyAction a = new FlyAction();
        ResultGenerator gen = new ResultGenerator();
        FlyResult r = new FlyResult(a, gen.generateJSONString());
        assertEquals(a, r.getAction());
    }
}