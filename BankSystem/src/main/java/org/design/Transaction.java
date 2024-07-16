package org.design;

public class Transaction {
  private int tellerId;
  private int customerId;

  public Transaction(int tellId, int customerId) {
    this.tellerId = tellId;
    this.customerId = customerId;
  }


  public int getCustomerId() {
    return customerId;
  }

  public String getTransactionDescription() {
    return "";
  }

  public int getTellerId() {
    return tellerId;
  }
}
