import model.*;
import controller.*;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class FilterAmountTest {

    @Test
    public void filterByAmount_returnsOnlyMatches() {
        ExpenseTrackerModel m = new ExpenseTrackerModel();
        DummyView v = new DummyView();
        ExpenseTrackerController c = new ExpenseTrackerController(m, v);

        m.addTransaction(new Transaction(10.0, "food"));
        m.addTransaction(new Transaction(20.0, "books"));

        List<Transaction> out = c.applyFilter("10.0", "");
        assertEquals(1, out.size());
        assertEquals(10.0, out.get(0).getAmount(), 0.001);
    }
}
