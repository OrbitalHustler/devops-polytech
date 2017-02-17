package spoonRewriter.Main;


import spoon.processing.AbstractProcessor;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.declaration.CtElement;

import java.util.Arrays;
import java.util.List;

public class MinusToPlus extends AbstractProcessor<CtElement> {
    public void process(CtElement element) {
//        if (element instanceof CtBinaryOperator<?>) {
//            CtBinaryOperator<?> op = (CtBinaryOperator<?>)element;
//
//            List<BinaryOperatorKind> arithmeticOperators =
//                    Arrays.asList(
//                            BinaryOperatorKind.PLUS,
//                            BinaryOperatorKind.MINUS,
//                            BinaryOperatorKind.MUL,
//                            BinaryOperatorKind.DIV
//                    );
//
//            // we may mutate with a certain probability
//            if (random.nextFloat()<MUTATION_PROBABILITY) {
//                // let's mutate arithmethic operators
//                if (arithmeticOperators.contains(op.getKind())) {
//                    op.setKind(arithmeticOperators.get(random.nextInt(arithmeticOperators.size())));
//                }
//            }
//        }
        if(element instanceof CtBinaryOperator)
            if (((CtBinaryOperator) element).getKind() == BinaryOperatorKind.MINUS)
                ((CtBinaryOperator) element).setKind(BinaryOperatorKind.PLUS);
    }
}
