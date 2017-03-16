package fr.unice.polytech.qgl.qbd.actions;

import fr.unice.polytech.qgl.qbd.gameObject.Direction;
import fr.unice.polytech.qgl.qbd.results.EchoResult;
import fr.unice.polytech.qgl.qbd.utils.ResultGenerator;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * PolyTech Nice / SI3 / Module POO-Java
 * Annee 2015 - qbd - Lab 3
 * Package fr.unice.polytech.qgl.qbd.actions
 *
 * @author Flavian Jacquot
 * @version 30/11/2015
 * @since 1.8.0_60
 */
public class EchoActionTest {
    @Test
    public void testToJSONString() {
        EchoAction a = new EchoAction(Direction.E);
        String result = a.toJSONString();
        JSONObject jsonObject = new JSONObject(result);

        String resAction = jsonObject.getString("action");
        assertEquals(Action.NAME.ECHO.toJSONString(), resAction);

        JSONObject param = jsonObject.getJSONObject("parameters");
        assertEquals(Direction.E.toJSONString(), param.getString("direction"));
    }

    @Test
    public void testGetDirection() throws Exception {
        EchoAction a = new EchoAction(Direction.N);
        assertEquals(Direction.N, a.getDirection());
    }

    @Test
    public void testCreateResult() throws Exception {
        EchoAction a = new EchoAction(Direction.N);
        ResultGenerator gen = new ResultGenerator();
        gen.addExtras("range", 3);
        gen.addExtras("found", "GROUND");

        EchoResult r = a.createResult(gen.generateJSONString());
        assertEquals(3, r.getRange());
        assertEquals(true, r.getGroundFound());
        assertEquals(a, r.getAction());
    }
}