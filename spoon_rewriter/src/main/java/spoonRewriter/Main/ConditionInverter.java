package spoonRewriter.Main;

import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtElement;
import spoon.support.reflect.code.CtIfImpl;

/**
 * Created by user on 02/03/2017.
 */
public class ConditionInverter  extends AbstractProcessor<CtElement> {

  public void process(CtElement element) {
    if(element instanceof CtIfImpl){
      processIf((CtIfImpl) element);
    }
  }
  
  public void processIf(CtIfImpl element){
    CtExpression<Boolean> cond = element.getCondition();
    CtStatement then = element.getThenStatement();
    CtStatement eles = element.getElseStatement();
    if(cond != null && then != null && eles != null){
      element.setThenStatement(eles);
      element.setElseStatement(then);
    }
  }
}
