package fr.unice.polytech.qgl.qbd.actions;

import fr.unice.polytech.qgl.qbd.results.StopResult;
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
public class StopActionTest {
    @Test
    public void testScan()
    {
        StopAction s = new StopAction();
        JSONObject jos = new JSONObject(s.toJSONString());
        assertEquals("stop", jos.getString("action"));
    }

    @Test
    public void testCreateResult() throws Exception {
        StopAction a = new StopAction();
        ResultGenerator gen = new ResultGenerator();
        StopResult r = a.createResult(gen.generateJSONString());

        assertEquals(a, r.getAction());
    }
}