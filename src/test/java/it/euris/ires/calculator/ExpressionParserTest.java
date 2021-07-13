package it.euris.ires.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExpressionParserTest {

  ExpressionParser expressionParser;

  @BeforeEach
  void setUp() {
    expressionParser = new ExpressionParser();
  }

  @Test
  void givenArithmeticExpressionWhenParseExpThenShouldReturnExpressionObject() {
    int operatorA = 1;
    int operatorB = 1;
    OperationType operatorType = OperationType.ADD;
    String arithmeticExpr = operatorA + " " + operatorType.getSymbol() + " " + operatorB;

    Expression expression = expressionParser.parseExpression(arithmeticExpr);

    assertThat(expression).isNotNull();
    assertThat(expression.operatorA).isEqualTo(operatorA);
    assertThat(expression.operatorA).isEqualTo(operatorB);
    assertThat(expression.getOperationType()).isEqualTo(operatorType);
  }

}
