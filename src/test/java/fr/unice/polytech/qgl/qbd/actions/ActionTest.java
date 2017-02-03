package fr.unice.polytech.qgl.qbd.actions;

import fr.unice.polytech.qgl.qbd.results.Result;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActionTest {

    @Test
    public void testInformation() throws Exception {
        //Nom au hasard
        Action a = new ActionTestable(Action.NAME.SCAN);
        a.addInformation(Action.INFO.MISC, "test");
        assertEquals("test", a.getInformation(Action.INFO.MISC));
    }

    @Test
    public void testGetName() throws Exception {
        Action a = new ActionTestable(Action.NAME.SCAN);
        assertEquals(Action.NAME.SCAN, a.getName());
    }

    @Test
    public void testToJSONString() throws Exception {
        Action a = new ActionTestable(Action.NAME.SCAN, "test1", "oui");
        a.addParameter("test2", "non");
        JSONObject obj = new JSONObject();
        JSONObject param = new JSONObject();
        obj.put("action", Action.NAME.SCAN.toJSONString());
        param.put("test1", "oui");
        param.put("test2", "non");
        obj.put("parameters", param);
        assertEquals(obj.toString(), a.toJSONString());
    }

    class ActionTestable extends Action{

        public ActionTestable(NAME name) {
            super(name);
        }

        public ActionTestable(NAME name, String key, String val){
            super (name, key, val);
        }

        @Override
        public Result createResult(String JSONResult) {
            return null;
        }
    }
}