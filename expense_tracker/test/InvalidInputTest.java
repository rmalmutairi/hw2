import controller.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class InvalidInputTest {

    @Test
    public void invalidAmount_isRejected() {
        ExpenseTrackerController c = new ExpenseTrackerController(new model.ExpenseTrackerModel(), new DummyView());
        boolean ok = c.addTransaction(-5.0, "food");
        assertFalse(ok);
    }
}
