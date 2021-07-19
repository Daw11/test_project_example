package it.euris.ires.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ExpressionServiceTest {

    ExpressionService expressionService;

    @Mock
    Calculator calculator;

    @Spy
    Calculator calculatorSpy;

    @Mock
    ExpressionParser expressionParser;


    @Test
    void givenArithmeticExpressionIsAddWhenCalculateExpressionThenCalculationIsAdd() {
        int operatorA = 1;
        int operatorB = 2;
        String arithmeticExpr = String.format("%d %s %d", operatorA, OperationType.ADD.getSymbol(), operatorB);
        Expression expression = new Expression(operatorA, operatorB, OperationType.ADD);
        int calcResult = 3;
        expressionService = new ExpressionService(expressionParser, calculator);

        Mockito.when(expressionParser.parseExpression(arithmeticExpr)).thenReturn(expression);
        Mockito.when(calculator.add(operatorA, operatorB)).thenReturn(calcResult);

        int result = expressionService.calculateExpression(arithmeticExpr);

        Mockito.verify(expressionParser, Mockito.times(1)).parseExpression(arithmeticExpr);
        Mockito.verify(calculator, Mockito.times(1)).add(operatorA, operatorB);
        Mockito.verify(calculator, Mockito.times(0)).subtract(operatorA, operatorB);
        Mockito.verify(calculator, Mockito.times(0)).division(operatorA, operatorB);
        Mockito.verify(calculator, Mockito.times(0)).multiplication(operatorA, operatorB);
    }

    @Test
    void givenArithmeticExpressionIsAddAndCalculatorIsSpyWhenCalculateExpressionThenCalculationIsAdd() {
        int operatorA = 1;
        int operatorB = 2;
        String arithmeticExpr = String.format("%d %s %d", operatorA, OperationType.ADD.getSymbol(), operatorB);
        Expression expression = new Expression(operatorA, operatorB, OperationType.ADD);
        int calcResult = 3;
        expressionService = new ExpressionService(expressionParser, calculatorSpy);
        Mockito.when(expressionParser.parseExpression(arithmeticExpr)).thenReturn(expression);

        int result = expressionService.calculateExpression(arithmeticExpr);

        assertThat(result).isEqualTo(calcResult);
        Mockito.verify(expressionParser, Mockito.times(1)).parseExpression(arithmeticExpr);
        Mockito.verify(calculatorSpy, Mockito.times(1)).add(operatorA, operatorB);
        Mockito.verify(calculatorSpy, Mockito.times(0)).subtract(operatorA, operatorB);
        Mockito.verify(calculatorSpy, Mockito.times(0)).division(operatorA, operatorB);
        Mockito.verify(calculatorSpy, Mockito.times(0)).multiplication(operatorA, operatorB);
    }

    @ParameterizedTest(name="givenCalculatorIsSpyWhenCalculateExpressionThenReturnCalculation")
    @EnumSource( OperationType.class )
    void calculateExpressionTestParameterized( OperationType ot ) {
        int operatorA = 1;
        int operatorB = 2;
        String arithmeticExpr = String.format("%d %s %d", operatorA, ot.getSymbol(), operatorB);
        expressionService = new ExpressionService( expressionParser, calculatorSpy );
        Expression expression = new Expression(operatorA, operatorB, ot);
        Mockito.when(expressionParser.parseExpression(arithmeticExpr)).thenReturn(expression);

        int result = expressionService.calculateExpression(arithmeticExpr);

        Mockito.verify(calculatorSpy, Mockito.times(ot == OperationType.ADD ? 1 : 0)).add(operatorA, operatorB);
        Mockito.verify(calculatorSpy, Mockito.times(ot == OperationType.SUBTRACTION ? 1 : 0)).subtract(operatorA, operatorB);
        Mockito.verify(calculatorSpy, Mockito.times(ot == OperationType.DIVISION ? 1 : 0)).division(operatorA, operatorB);
        Mockito.verify(calculatorSpy, Mockito.times(ot == OperationType.MULTIPLICATION ? 1 : 0)).multiplication(operatorA, operatorB);
    }

//    @Test
//    void givenWrongArithmeticExpressionWhenCalculateExpressionThenThrowException(){
//        int operatorA = 1;
//        int operatorB = 2;
//        String arithmeticExpr = String.format("%d %s %d", operatorA,"$%&", operatorB);
//        expressionService = new ExpressionService(expressionParser, calculator);
//        Expression expression = new Expression(operatorA, operatorB, null);
//        Mockito.when(expressionParser.parseExpression(arithmeticExpr)).thenReturn(expression);
//
//        assertThrows(UnsupportedOperationException.class, () -> expressionService.calculateExpression(arithmeticExpr));
//    }
}