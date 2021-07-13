package it.euris.ires.testDoubles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaymentServiceTest {

  PaymentService paymentService;

  @BeforeEach
  void setUp() {
    ILogger logger = new LoggerDummy();
    IOperatorRate operatorRate = new OperatorRateStub(10);
    paymentService = new PaymentService(logger, operatorRate);
  }

  @Test
  void givenSaleAndCreditCardWhenCreatePaymentRequestThenReturnPaymentRequest() {
    Customer customer= new Customer("name", "address");
    Item item = new Item("item", 1000);
    List<Item> items = new ArrayList<>();
    items.add(item);
    Sale sale = new Sale(customer, items);
    CreditCard creditCard = new CreditCard(customer, "1");
    PaymentRequest expectedResult = new PaymentRequest(1000, "1", 10);

    PaymentRequest result = paymentService.createPaymentRequest(sale, creditCard);

    assertThat(result).isEqualTo(expectedResult);
  }

}
