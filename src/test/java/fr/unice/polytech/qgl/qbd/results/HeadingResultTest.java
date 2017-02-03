package fr.unice.polytech.qgl.qbd.results;

import fr.unice.polytech.qgl.qbd.actions.HeadingAction;
import fr.unice.polytech.qgl.qbd.gameObject.Direction;
import fr.unice.polytech.qgl.qbd.utils.ResultGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeadingResultTest {

    @Test
    public void testGetAction() throws Exception {
        HeadingAction a = new HeadingAction(Direction.W);
        ResultGenerator gen = new ResultGenerator();
        HeadingResult r = new HeadingResult(a, gen.generateJSONString());
        assertEquals(a, r.getAction());
    }
}