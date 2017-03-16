package fr.unice.polytech.qgl.qbd.actions;

import fr.unice.polytech.qgl.qbd.gameObject.Direction;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class ActionGeneratorTest {

    @Test
    public void test() throws Exception {
        LinkedList<Action> list = new LinkedList<>();
        ActionGeneratorTestable gen = new ActionGeneratorTestable(list);
        gen.addInformations(Action.INFO.MISC, "test");
        EchoAction action = new EchoAction(Direction.W);
        gen.addAction(action);
        assertEquals(action, list.get(0));
        assertEquals("test", list.get(0).getInformation(Action.INFO.MISC));
    }

    class ActionGeneratorTestable extends ActionGenerator{

        public ActionGeneratorTestable(LinkedList<Action> actionList) {
            super(actionList);
        }
    }
}