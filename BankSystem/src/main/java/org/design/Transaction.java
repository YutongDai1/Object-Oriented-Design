package org.design;

public class Transaction {
  private int tellId;
  private int customerId;

  public Transaction(int tellId, int customerId) {
    this.tellId = tellId;
    this.customerId = customerId;
  }

  public int getTellId() {
    return tellId;
  }

  public int getCustomerId() {
    return customerId;
  }

  public String getTransactionDescription() {
    return "";
  }
}
