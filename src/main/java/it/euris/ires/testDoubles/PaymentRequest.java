package it.euris.ires.testDoubles;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentRequest {

  private int amount;
  private String pan;
  private int feeRate;

}
