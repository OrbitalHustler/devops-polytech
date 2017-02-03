package fr.unice.polytech.qgl.qbd.results;

import fr.unice.polytech.qgl.qbd.actions.EchoAction;
import fr.unice.polytech.qgl.qbd.gameObject.Direction;
import fr.unice.polytech.qgl.qbd.utils.ResultGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

public class EchoResultTest {

    @Test
    public void test() throws Exception {
        EchoAction a = new EchoAction(Direction.W);
        ResultGenerator gen = new ResultGenerator();
        gen.addExtras("range", 5);
        gen.addExtras("found", "GROUND");
        EchoResult r = new EchoResult(a, gen.generateJSONString());
        assertEquals(5, r.getRange());
        assertEquals(true, r.getGroundFound());
        assertEquals(a, r.getAction());

        //Test si terre non trouvée
        gen.addExtras("range", 5);
        gen.addExtras("found", "OUT_OF_RANGE");
        r = new EchoResult(a, gen.generateJSONString());
        assertEquals(false, r.getGroundFound());
    }
}