package org.design;

public class BankAccount {
  private int customerId;
  private String name;
  private double balance;

  public BankAccount(int customerId, String name, double balance) {
    this.customerId = customerId;
    this.name = name;
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

  public boolean withdraw(double money) {
    if (money > balance) {
      return false;
    }
    balance -= money;
    return true;
  }

  public boolean deposit(double money) {
    balance +=money;
    return true;
  }
}
