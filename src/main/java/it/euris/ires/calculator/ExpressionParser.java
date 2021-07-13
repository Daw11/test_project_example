package it.euris.ires.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionParser {

  public Expression parseExpression(String arithmeticExpr) {
    String regex = "(\\d+)( ){0,}([+-/*])( ){0,}(\\d+)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(arithmeticExpr);
    if (matcher.find()) {
      int firstOperator = Integer.parseInt(matcher.group(1));
      int secondOperator = Integer.parseInt(matcher.group(5));
      OperationType opType = opTypeFactory(matcher.group(3));
      return new Expression(firstOperator, secondOperator, opType);
    } else {
      throw new RuntimeException(String.format("could not parse expression %s", arithmeticExpr));
    }
  }

  private OperationType opTypeFactory(String opType) {
    if (OperationType.ADD.getSymbol().equals(opType)) {
      return OperationType.ADD;
    } else if (OperationType.SUBTRACTION.getSymbol().equals(opType)) {
      return OperationType.SUBTRACTION;
    } else if (OperationType.MULTIPLICATION.getSymbol().equals(opType)) {
      return OperationType.MULTIPLICATION;
    } else if (OperationType.DIVISION.getSymbol().equals(opType)) {
      return OperationType.DIVISION;
    } else {
      throw new IllegalStateException("Unexpected value: " + opType);
    }
  }

}
