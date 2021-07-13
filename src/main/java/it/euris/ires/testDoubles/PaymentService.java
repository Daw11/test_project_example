package it.euris.ires.testDoubles;

public class PaymentService {

  private final ILogger logger;
  private final IOperatorRate operatorRate;
  private final IPaymentEmailSender emailSender;

  public PaymentService(ILogger logger, IOperatorRate operatorRate, IPaymentEmailSender emailSender) {
    this.logger = logger;
    this.operatorRate = operatorRate;
    this.emailSender = emailSender;
  }

  public PaymentRequest createPaymentRequest(Sale sale, CreditCard creditCard) {
    logger.append("Creating payment for sale " + sale.toString());

    int totalAmount = sale.getItemList().stream()
        .mapToInt(Item::getAmount)
        .sum();
    int feeRate = operatorRate.feeRate("random_id");
    int fee = (feeRate * totalAmount) / 100;

    PaymentRequest paymentRequest = new PaymentRequest(totalAmount, creditCard.getPan(), fee);

    if (totalAmount > 1000) {
      emailSender.send(paymentRequest);
    }

    return paymentRequest;
  }
}
