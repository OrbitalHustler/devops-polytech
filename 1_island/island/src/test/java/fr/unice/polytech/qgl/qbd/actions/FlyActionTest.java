package fr.unice.polytech.qgl.qbd.actions;

import fr.unice.polytech.qgl.qbd.results.FlyResult;
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
public class FlyActionTest {

    @Test
    public void testFly()
    {
        String action = "fly";

        Action a = new FlyAction();
        String result = a.toJSONString();
        JSONObject jsonObject = new JSONObject(result);

        String resAction = jsonObject.getString("action");
        assertEquals(action, resAction);
    }

    @Test
    public void testCreateResult() throws Exception {
        FlyAction a = new FlyAction();
        ResultGenerator gen = new ResultGenerator();
        FlyResult r = a.createResult(gen.generateJSONString());

        assertEquals(a, r.getAction());
    }
}