package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExpenseTrackerModel {

  // make it private + final so no other class can touch or reassign it
  private final List<Transaction> transactions = new ArrayList<>();

  // constructor no longer needs to re‑assign the field
  public ExpenseTrackerModel() {}

  public void addTransaction(Transaction t) {
    transactions.add(t);
  }

  public void removeTransaction(Transaction t) {
    transactions.remove(t);
  }

  public List<Transaction> getTransactions() {
    return Collections.unmodifiableList(transactions);
  }

  // Returns the sum of all transaction amounts
  public double getTotalCost() {
    return transactions.stream()
                      .mapToDouble(Transaction::getAmount)
                      .sum();
  }


}