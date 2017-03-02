package spoonRewriter.Main;


import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtLiteral;

import java.util.Random;

public class AddToVariables extends AbstractProcessor<CtLiteral> {
    public void process(CtLiteral element) {
        int x = (new Random().nextInt() % 5);
        if (element.getValue() instanceof Integer)
            element.setValue((Integer)element.getValue() + x);
        else if (element.getValue() instanceof Double || element.getValue() instanceof Float)
            element.setValue((Double)element.getValue() + x );
        // modifier les strings comme ça fait trop d'erreurs
//        else if (element.getValue() instanceof String)
//            element.setValue((String)element.getValue() + "zzz");
    }
}
