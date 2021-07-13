package it.euris.ires.testDoubles;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreditCardRateServiceTest {

  IPaymentGateway paymentGateway;
  CreditCardRateService creditCardRateService;

  @BeforeEach
  void setUp() {
    paymentGateway = new PaymentGatewayFake();
    creditCardRateService = new CreditCardRateService(paymentGateway);
  }

  @Test
  void givenOperatorIdThatStartWithOneWhenGetFeeRateThenReturnFeeRateOf10() {
    String operatorId = "100010";

    int result = creditCardRateService.feeRate(operatorId);

    assertThat(result).isEqualTo(10);
  }

}
