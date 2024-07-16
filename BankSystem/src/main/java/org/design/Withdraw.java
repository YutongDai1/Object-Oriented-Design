package org.design;

public class Withdraw extends Transaction{
  private double amount;
  public Withdraw(int tellId, int customerId, double amount) {
    super(tellId, customerId);
    this.amount = amount;
  }
  @Override
  public String getTransactionDescription() {
    return "Customer " + getCustomerId() + " withdrawed " + amount + "----" + " teller " + getTellerId();
  }

}
