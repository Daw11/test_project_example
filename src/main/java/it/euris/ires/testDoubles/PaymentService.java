package it.euris.ires.testDoubles;

public class PaymentService {

  private final ILogger logger;

  public PaymentService(ILogger logger) {
    this.logger = logger;
  }

  public PaymentRequest createPaymentRequest(Sale sale, CreditCard creditCard) {
    logger.append("Creating payment for sale " + sale.toString());
    int totalAmount = sale.getItemList().stream()
        .mapToInt(Item::getAmount)
        .sum();
    return new PaymentRequest(totalAmount, creditCard.getPan());
  }
}
