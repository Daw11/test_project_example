package it.euris.ires;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTests {

	@Test
	void givenAddWhenInputsBoth1ThenReturn2() {
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
	@DisplayName("GIVEN subtract method WHEN first operator is 1 AND second operator is 1 THEN should return 0")
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

	@ParameterizedTest(name = "GivenFirstArgument {0} AndSecondArgument {1} WhenAddThenShouldReturn {2}")
	@CsvSource({
			"0,    1,   1",
			"0,   -1,  -1",
			"-50,  50,  0",
			Integer.MAX_VALUE + ", "+ Integer.MAX_VALUE + ", -2"
	})
	void addWithBvaValues(int first, int second, int expectedResult) {
		Calculator calculator = new Calculator();
		assertEquals(expectedResult, calculator.add(first, second),
				() -> first + " + " + second + " should equal " + expectedResult);
	}

}
