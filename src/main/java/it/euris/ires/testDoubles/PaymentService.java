package it.euris.ires.testDoubles;

public class PaymentService {

  private final ILogger logger;
  private final IOperatorRate operatorRate;

  public PaymentService(ILogger logger, IOperatorRate operatorRate) {
    this.logger = logger;
    this.operatorRate = operatorRate;
  }

  public PaymentRequest createPaymentRequest(Sale sale, CreditCard creditCard) {
    logger.append("Creating payment for sale " + sale.toString());
    int totalAmount = sale.getItemList().stream()
        .mapToInt(Item::getAmount)
        .sum();
    int feeRate = operatorRate.feeRate("random_id");
    return new PaymentRequest(totalAmount, creditCard.getPan(), feeRate);
  }
}
