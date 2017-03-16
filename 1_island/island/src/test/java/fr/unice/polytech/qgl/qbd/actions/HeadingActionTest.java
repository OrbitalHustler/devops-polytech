package fr.unice.polytech.qgl.qbd.actions;

import fr.unice.polytech.qgl.qbd.gameObject.Direction;
import fr.unice.polytech.qgl.qbd.results.HeadingResult;
import fr.unice.polytech.qgl.qbd.utils.ResultGenerator;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * PolyTech Nice / SI3 / Module POO-Java
 * Annee 2015 - qbd - Lab 3
 * Package fr.unice.polytech.qgl.qbd.actions
 *
 * @author Flavian Jacquot
 * @version 01/01/2016
 * @since 1.8.0_60
 */
public class HeadingActionTest {
    @Test
    public void testHeading()
    {
        HeadingAction h = new HeadingAction(Direction.N);
        JSONObject res = new JSONObject(h.toJSONString());

        assertEquals("heading", res.getString("action"));
        assertEquals(Direction.N.toJSONString(), res.getJSONObject("parameters").getString("direction"));

    }

    @Test
    public void testGetDirection() throws Exception {
        HeadingAction a = new HeadingAction(Direction.S);
        assertEquals(Direction.S, a.getDirection());
    }

    @Test
    public void testCreateResult() throws Exception {
        HeadingAction a = new HeadingAction(Direction.W);
        ResultGenerator gen = new ResultGenerator();
        HeadingResult r = a.createResult(gen.generateJSONString());

        assertEquals(a, r.getAction());
    }
}