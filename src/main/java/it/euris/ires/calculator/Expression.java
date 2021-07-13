package it.euris.ires.calculator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Expression {

  int operatorA;
  int operatorB;
  OperationType operationType;

}
