package filter;

import model.Transaction;
import java.util.List;
import java.util.stream.Collectors;

public class AmountFilter implements TransactionFilter {

    private final double target;

    public AmountFilter(double target) { this.target = target; }

    @Override
    public List<Transaction> filter(List<Transaction> txs) {
        return txs.stream()
                  .filter(t -> t.getAmount() == target)
                  .collect(Collectors.toList());
    }
}