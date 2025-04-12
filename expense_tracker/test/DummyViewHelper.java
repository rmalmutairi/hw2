import view.ExpenseTrackerView;
import model.Transaction;
import java.util.List;
import org.junit.Ignore; 
import model.*;

@Ignore("Helper class – not a test")
public class DummyViewHelper extends ExpenseTrackerView {
    @Override public void refreshTable(List<Transaction> txs) {
        /* no UI in tests */
    }
}
