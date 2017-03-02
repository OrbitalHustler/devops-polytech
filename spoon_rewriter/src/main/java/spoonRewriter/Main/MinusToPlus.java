package spoonRewriter.Main;


import spoon.processing.AbstractProcessor;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.declaration.CtElement;

import java.util.Arrays;
import java.util.List;

public class MinusToPlus extends AbstractProcessor<CtElement> {
    public void process(CtElement element) {
        if(element instanceof CtBinaryOperator)
            if (((CtBinaryOperator) element).getKind() == BinaryOperatorKind.MINUS)
                ((CtBinaryOperator) element).setKind(BinaryOperatorKind.PLUS);
    }
}
