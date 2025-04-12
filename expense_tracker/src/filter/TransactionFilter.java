package filter;

import model.Transaction;
import java.util.List;

/** Strategy interface for filtering transactions. */
public interface TransactionFilter {
    List<Transaction> filter(List<Transaction> txs);
}
