package it.euris.ires.calculator;

import lombok.Getter;

public enum OperationType {

  ADD("+"),
  SUBTRACTION("-"),
  MULTIPLICATION("*"),
  DIVISION("/");

  @Getter
  private final String symbol;

  OperationType(String symbol) {
    this.symbol = symbol;
  }

}
