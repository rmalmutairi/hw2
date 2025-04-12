package controller;

import view.ExpenseTrackerView;

import java.util.List;

import filter.AmountFilter;
import filter.CategoryFilter;
import filter.TransactionFilter;
import model.ExpenseTrackerModel;
import model.Transaction;

public class ExpenseTrackerController {
  
  private ExpenseTrackerModel model;
  private ExpenseTrackerView view;

  public ExpenseTrackerController(ExpenseTrackerModel model, ExpenseTrackerView view) {
    this.model = model;
    this.view = view;

    // Set up view event handlers
  }

  public void refresh() {

    // Get transactions from model
    List<Transaction> transactions = model.getTransactions();

    // Pass to view
    view.refreshTable(transactions);

  }

  public boolean addTransaction(double amount, String category) {
    if (!InputValidation.isValidAmount(amount)) {
      return false;
    }
    if (!InputValidation.isValidCategory(category)) {
      return false;
    }
    
    Transaction t = new Transaction(amount, category);
    model.addTransaction(t);
    view.getTableModel().addRow(new Object[]{t.getAmount(), t.getCategory(), t.getTimestamp()});
    refresh();
    return true;
  }

  /**
 * Filters the model’s transactions by either amount *or* category
 * and refreshes the view.  Returns the filtered list so tests can
 * assert on it.
 *
 * @param amountTxt   text from an amount input (may be empty)
 * @param categoryTxt text from a category input (may be empty)
 * @return list of transactions that match the filter
 * @throws IllegalArgumentException if both or neither fields are filled
 */
public List<Transaction> applyFilter(String amountTxt, String categoryTxt) {
    TransactionFilter filter;

    boolean hasAmount   = !amountTxt.trim().isEmpty();
    boolean hasCategory = !categoryTxt.trim().isEmpty();

    if (hasAmount == hasCategory) {      // either both filled or both empty
        throw new IllegalArgumentException("Enter *either* amount OR category");
    }

    if (hasAmount) {
        double amt = Double.parseDouble(amountTxt);
        filter = new AmountFilter(amt);
    } else { // hasCategory
        filter = new CategoryFilter(categoryTxt);
    }

    List<Transaction> result = filter.filter(model.getTransactions());
    view.refreshTable(result);           // reuse your existing table method
    return result;                       // handy for unit tests
}
  
  // Other controller methods
}