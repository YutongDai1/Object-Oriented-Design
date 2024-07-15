package org.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BankBranch {
  private String address;
  private double cashOnHand;
  private BankSystem bankSystem;
  private List<BankTeller> tellers;

  public BankBranch(String address, int cashOnHand, BankSystem bankSystem) {
    this.address = address;
    this.cashOnHand = cashOnHand;
    this.bankSystem = bankSystem;
    this.tellers = new ArrayList<>();
  }

  private BankTeller getAvailableTeller() {
    Random random = new Random();
    int index = random.nextInt(this.tellers.size());
    return this.tellers.get(index);
  }

  public void openAccount(String customerName) {
    if (this.tellers.size() == 0) {
      throw new Error("Branch does not have any tellers");
    }

    int availableTeller = getAvailableTeller().getId();
    this.bankSystem.openAccount(customerName, availableTeller);
  }

  public void deposit(int customerId, double money) {
    if (this.tellers.size() == 0) {
      throw new Error("Branch does not have any tellers");
    }
    this.cashOnHand += money;
    int availableTeller = getAvailableTeller().getId();
    this.bankSystem.deposit(customerId, availableTeller, money);
  }

  public void withdraw(int customerId, double money) {
    if (money > this.cashOnHand) {
      throw new Error("Branch does not have enough cash");
    }
    if (this.tellers.size() == 0) {
      throw new Error("Branch does not have any tellers");
    }
    this.cashOnHand -= money;
    int availableTeller = getAvailableTeller().getId();
    this.bankSystem.withdraw(customerId, availableTeller, money);
  }


  public double collectCash(int ratio) {
    double cashCollected = ratio * cashOnHand;
    cashOnHand -= cashCollected;
    return cashCollected;
  }
}
