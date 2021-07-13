package it.euris.ires.testDoubles;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

public class PaymentEmailSenderMock implements IPaymentEmailSender {

  private final List<PaymentRequest> paymentRequestSent = new ArrayList<>();
  private final List<PaymentRequest> expectedPaymentRequest = new ArrayList<>();

  @Override
  public void send(PaymentRequest paymentRequest) {
    paymentRequestSent.add(paymentRequest);
  }

  public void expect(PaymentRequest paymentRequest) {
    expectedPaymentRequest.add(paymentRequest);
  }

  public void verify() {
    assertThat(paymentRequestSent).isEqualTo(expectedPaymentRequest);
  }

}
