package it.euris.ires.calculator;

public class ExpressionService {

  ExpressionParser parser;
  Calculator calculator;

  public ExpressionService(ExpressionParser parser, Calculator calculator) {
    this.parser = parser;
    this.calculator = calculator;
  }

  public int calculateExpression(String arithmeticExpression) {
    Expression expression = parser.parseExpression(arithmeticExpression);
    switch (expression.getOperationType()) {
      case ADD:
        return calculator.add(expression.operatorA, expression.operatorB);
      case SUBTRACTION:
        return calculator.subtract(expression.operatorA, expression.operatorB);
      case MULTIPLICATION:
        return calculator.multiplication(expression.operatorA, expression.operatorB);
      case DIVISION:
        return calculator.division(expression.operatorA, expression.operatorB);
      default:
        throw new UnsupportedOperationException();
    }
  }

}
