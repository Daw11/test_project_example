package it.euris.ires.testDoubles;

import com.google.gson.Gson;

public class CreditCardRateService implements IOperatorRate {

  private final IPaymentGateway IPaymentGateway;

  public CreditCardRateService(IPaymentGateway IPaymentGateway) {
    this.IPaymentGateway = IPaymentGateway;
  }

  @Override
  public int feeRate(String operator) {
    String rateJson = IPaymentGateway.rateFor(operator);
    OperatorRate operatorRate = parse(rateJson);
    return operatorRate.getFeeRate();
  }

  private OperatorRate parse(String rateJson) {
    Gson gson = new Gson();
    return gson.fromJson(rateJson, OperatorRate.class);
  }


}