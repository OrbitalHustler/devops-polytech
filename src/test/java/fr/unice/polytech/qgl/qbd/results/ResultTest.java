package fr.unice.polytech.qgl.qbd.results;

import fr.unice.polytech.qgl.qbd.actions.Action;
import fr.unice.polytech.qgl.qbd.utils.ResultGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResultTest {

    @Test
    public void test() throws Exception {
        ResultGenerator gen = new ResultGenerator();
        //Valeurs par défaut: cost = 1, status = true
        gen.addExtras("test", "oui");
        ResultTestable r = new ResultTestable(gen.generateJSONString());
        assertEquals(1, r.getCost());
        assertEquals(true, r.getStatus());
    }

    class ResultTestable extends Result{
        Action a;

        public ResultTestable(String JSONResult) {
            super(JSONResult);
        }

        @Override
        public Action getAction() {
            return null;
        }
    }
}