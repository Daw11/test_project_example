package it.euris.ires.testDoubles;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreditCard {

  private Customer customer;
  private String pan;

}
