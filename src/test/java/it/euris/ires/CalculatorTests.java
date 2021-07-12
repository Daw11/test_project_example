package it.euris.ires;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTests {

	@Test
	@DisplayName("1 + 1 = 2")
	void addsTwoNumbers() {
		// arrange
		int numberA = 1;
		int numberB = 1;
		int expectedResult = 2;
		Calculator calculator = new Calculator();
		// act
		int result = calculator.add(numberA, numberB);
		// assert
		assertEquals(expectedResult, result,
				String.format("%s + %s should equal %s", numberA, numberB, expectedResult));
	}

	@Test
	@DisplayName("1 - 1 = 0")
	void subtractTwoNumbers() {
		// arrange
		int numberA = 1;
		int numberB = 1;
		int expectedResult = 0;
		Calculator calculator = new Calculator();
		// act
		int result = calculator.subtract(numberA, numberB);
		// assert
		assertEquals(expectedResult, result,
				String.format("%s + %s should equal %s", numberA, numberB, expectedResult));
	}

}
