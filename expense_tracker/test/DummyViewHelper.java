import view.ExpenseTrackerView;
import model.Transaction;
import java.util.List;

/** Minimal no‑UI stub so controller compiles in unit tests. */
public class DummyView extends ExpenseTrackerView {
    @Override public void refreshTable(List<Transaction> txs) {
        /* no UI in tests */
    }
}
