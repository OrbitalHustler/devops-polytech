package spoonRewriter.Main;


import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBinaryOperator;

import static spoon.reflect.code.BinaryOperatorKind.*;

public class OperatorsSwapper extends AbstractProcessor<CtBinaryOperator> {
    public void process(CtBinaryOperator element) {
        switch(element.getKind()){
            case MUL:
                element.setKind(DIV);
                break;
            case DIV:
                element.setKind(MUL);
                break;
            case AND:
                element.setKind(OR);
                break;
            case OR:
                element.setKind(AND);
        }
    }
}
