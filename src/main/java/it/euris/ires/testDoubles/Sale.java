package it.euris.ires.testDoubles;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sale {

  private Customer customer;
  private List<Item> itemList;

}
