package org.design;

import java.util.List;

public class BankSystem {
  private List<BankAccount> bankAccounts;
  private List<Transaction> transactions;

  public BankSystem(List<BankAccount> accounts, List<Transaction> transactions) {
    this.bankAccounts = accounts;
    this.transactions = transactions;
  }

  public BankAccount getAccount(int customerId) {
    return this.bankAccounts.get(customerId);
  }

  public List<BankAccount> getAccounts() {
    return this.bankAccounts;
  }

  public List<Transaction> getTransactions() {
    return this.transactions;
  }

  public int openAccount(String name, int tellerId){
    int customerId = bankAccounts.size();
    BankAccount bankAccount = new BankAccount(customerId, name, 0);
    bankAccounts.add(bankAccount);

    Transaction transaction = new OpenAccount(tellerId, customerId);
    transactions.add(transaction);
    return customerId;
  }
  public void withdraw(int customerId, int tellerId, double amount) {
    BankAccount bankAccount = this.bankAccounts.get(customerId);
    if (!bankAccount.withdraw(amount)) {
      throw new Error("Insufficient funds");
    }


    Transaction transaction = new Withdraw(tellerId, customerId, amount);
    transactions.add(transaction);
  }
  public void deposit(int customerId, int tellerId, double amount) {
    BankAccount bankAccount = this.bankAccounts.get(customerId);
    bankAccount.deposit(amount);

    Transaction transaction = new Deposit(tellerId, customerId, amount);
    transactions.add(transaction);
  }


}
