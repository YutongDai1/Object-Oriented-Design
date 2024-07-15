package org.design;

import java.util.List;

public class Bank {
  private List<BankBranch> bankBranches;
  private BankSystem bankSystem;
  private double bankCash;

  public Bank(List<BankBranch> branches, BankSystem bankSystem, int totalCash) {
    this.bankBranches = branches;
    this.bankSystem = bankSystem;
    this.bankCash = totalCash;
  }
  public BankBranch addBranch(String address, int initialFunds) {
    BankBranch branch = new BankBranch(address, initialFunds, this.bankSystem);
    this.bankBranches.add(branch);
    return branch;
  }

  public void collectCash(int ratio) {
    for (BankBranch bankBranch : bankBranches) {
      bankCash += bankBranch.collectCash(ratio);
    }
  }

  
}
