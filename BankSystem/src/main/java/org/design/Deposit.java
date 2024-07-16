package org.design;

public class Deposit extends Transaction{
  private double amount;
  public Deposit(int tellId, int customerId, double amount) {
    super(tellId, customerId);
    this.amount = amount;
  }

  @Override
  public String getTransactionDescription() {
    return "Customer " + getCustomerId() + " deposited " + amount + "----" + " teller " + getTellerId();
  }


}
