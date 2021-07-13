package it.euris.ires.testDoubles;

import java.util.ArrayList;
import java.util.List;

public class PaymentEmailSpy implements IPaymentEmailSender {

  private List<PaymentRequest> paymentRequests = new ArrayList<>();

  @Override
  public void send(PaymentRequest paymentRequest) {
    paymentRequests.add(paymentRequest);
  }

  public int timesCalled() {
    return paymentRequests.size();
  }

  public boolean calledWith(PaymentRequest paymentRequest) {
    return paymentRequests.contains(paymentRequest);
  }

}
