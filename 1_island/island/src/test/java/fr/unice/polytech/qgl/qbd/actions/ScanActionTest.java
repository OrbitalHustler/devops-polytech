package fr.unice.polytech.qgl.qbd.actions;

import fr.unice.polytech.qgl.qbd.results.ScanResult;
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
public class ScanActionTest {

    @Test
    public void testScan()
    {
        ScanAction s = new ScanAction();
        JSONObject jos = new JSONObject(s.toJSONString());
        assertEquals("scan", jos.getString("action"));
    }

    @Test
    public void testCreateResult() throws Exception {
        ScanAction a = new ScanAction();
        ResultGenerator gen = new ResultGenerator();
        ScanResult r = a.createResult(gen.generateJSONString());

        assertEquals(a, r.getAction());
    }
}