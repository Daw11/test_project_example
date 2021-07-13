package it.euris.ires.testDoubles;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {

  private String description;
  private int amount;

}
