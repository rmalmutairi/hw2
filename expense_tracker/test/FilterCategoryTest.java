import model.*;
import controller.*;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class FilterCategoryTest {

    @Test
    public void filterByCategory_returnsOnlyMatches() {
        ExpenseTrackerModel m = new ExpenseTrackerModel();
        DummyViewHelper v = new DummyViewHelper();
        ExpenseTrackerController c = new ExpenseTrackerController(m, v);

        m.addTransaction(new Transaction(15.0, "travel"));
        m.addTransaction(new Transaction(30.0, "food"));

        List<Transaction> out = c.applyFilter("", "travel");
        assertEquals(1, out.size());
        assertEquals("travel", out.get(0).getCategory());
    }
}
