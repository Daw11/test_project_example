package it.euris.ires.testDoubles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PaymentServiceTest {

  PaymentService paymentService;

  ILogger logger;
  IOperatorRate operatorRate;
  PaymentEmailSenderMock emailSenderMock;
  PaymentEmailSpy emailSenderSpy;

  @BeforeEach
  void setUp() {
    logger = new LoggerDummy();
    operatorRate = new OperatorRateStub(10);
    emailSenderMock = new PaymentEmailSenderMock();
    emailSenderSpy = new PaymentEmailSpy();
  }

  @Test
  void givenSaleAndCreditCardWhenCreatePaymentRequestThenReturnPaymentRequest() {
    Customer customer= new Customer("name", "address");
    Item item = new Item("item", 1000);
    List<Item> items = new ArrayList<>();
    items.add(item);
    Sale sale = new Sale(customer, items);
    CreditCard creditCard = new CreditCard(customer, "1");
    PaymentRequest expectedResult = new PaymentRequest(1000, "1", 100);
    paymentService = new PaymentService(logger, operatorRate, emailSenderSpy);

    PaymentRequest result = paymentService.createPaymentRequest(sale, creditCard);

    assertThat(result).isEqualTo(expectedResult);
    assertThat(emailSenderSpy.timesCalled()).isEqualTo(0);
  }

  @Test
  void givenSaleOver1000AndCreditCardWhenCreatePaymentRequestThenReturnPaymentRequestThenSendMail() {
    Customer customer= new Customer("name", "address");
    Item item = new Item("item", 1001);
    List<Item> items = new ArrayList<>();
    items.add(item);
    Sale sale = new Sale(customer, items);
    CreditCard creditCard = new CreditCard(customer, "1");
    PaymentRequest expectedResult = new PaymentRequest(1001, "1", 100);
    emailSenderMock.expect(expectedResult);
    paymentService = new PaymentService(logger, operatorRate, emailSenderMock);

    PaymentRequest result = paymentService.createPaymentRequest(sale, creditCard);

    assertThat(result).isEqualTo(expectedResult);
    emailSenderMock.verify();
  }

}
