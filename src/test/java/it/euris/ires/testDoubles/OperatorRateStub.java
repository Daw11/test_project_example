package it.euris.ires.testDoubles;

public class OperatorRateStub implements IOperatorRate {

  private final int rate;

  public OperatorRateStub(int rate) {
    this.rate = rate;
  }

  @Override
  public int feeRate(String operatorId) {
    return this.rate;
  }
}
