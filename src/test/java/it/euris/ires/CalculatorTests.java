package it.euris.ires;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTests {

	@Test
	@DisplayName("1 + 1 = 2")
	void addsTwoNumbers() {
		Calculator calculator = new Calculator();
		assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
	}

	@Test
	@DisplayName("1 - 1 = 0")
	void subtractTwoNumbers() {
		Calculator calculator = new Calculator();
		assertEquals(0, calculator.subtract(1, 1), "1 + 1 should equal 0");
	}

}
