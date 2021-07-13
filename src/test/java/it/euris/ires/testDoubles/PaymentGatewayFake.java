package it.euris.ires.testDoubles;

import com.google.gson.Gson;

public class PaymentGatewayFake implements IPaymentGateway {

  @Override
  public String rateFor(String cardOperator) {
    int rate = 15;
    String operatorType = "masterCard";
    OperatorRate operatorRate = new OperatorRate(operatorType, rate);

    if (cardOperator.startsWith("1")) {
      operatorRate.setOperatorType("visa");
      operatorRate.setFeeRate(10);
    }

    if (cardOperator.startsWith("0")) {
      operatorRate.setOperatorType("maestro");
      operatorRate.setFeeRate(8);
    }

    Gson gson = new Gson();
    return gson.toJson(operatorRate);
  }



}
