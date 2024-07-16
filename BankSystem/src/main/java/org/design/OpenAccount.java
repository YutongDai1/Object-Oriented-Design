package org.design;

public class OpenAccount extends Transaction{

  public OpenAccount(int tellId, int customerId) {
    super(tellId, customerId);
  }

  @Override
  public String getTransactionDescription() {
    return "Customer " + getCustomerId() + " opened account " +  "----" + " teller " + getTellerId();
  }
}
