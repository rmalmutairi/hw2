import model.*;
import controller.ExpenseTrackerController;
import org.junit.Test;
import static org.junit.Assert.*;


/** Verifies that addTransaction inserts a row and updates totals. */
public class AddTransactionTest {

    @Test
    public void addTransaction_updatesModel() {
        ExpenseTrackerModel m = new ExpenseTrackerModel();
        DummyView v = new DummyView();
        ExpenseTrackerController c = new ExpenseTrackerController(m, v);

        boolean ok = c.addTransaction(50.0, "food");

        assertTrue(ok);
        assertEquals(1, m.getTransactions().size());
        assertEquals(50.0, m.getTotalCost(), 0.001);
    }
}
